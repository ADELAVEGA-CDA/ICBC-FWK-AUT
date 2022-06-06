package api.utils;

import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Cookies;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiBaseCaller {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    public String url;
    protected String env;
    protected String service;
    protected String version;
    protected String userAgent;
    protected Map<String, String> headers = new HashMap<>();
    protected Map<String, String> body = new HashMap<>();
    public String bodyString;
    protected Cookies cookies;
    protected Response response;

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }

    public void setBody(String body) {
        this.bodyString = body;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    protected void useRelaxedHttpsValidation() {
        if (System.getenv("CHECK_CERT") != null && System.getenv("CHECK_CERT").equals("0")) {
            RestAssured.useRelaxedHTTPSValidation();
            logger.info("Using useRelaxedHTTPSValidation for request");
        }
    }

    protected RestAssuredConfig useCurlLogging() {
        Options options = Options.builder().printSingleliner().build();
        return CurlRestAssuredConfigFactory.createConfig(options);
    }

    public Response post() {
        String requestMethod = "POST";
        RestAssured.defaultParser = Parser.JSON;
        this.useRelaxedHttpsValidation();

        RestAssuredConfig config = this.useCurlLogging();

        printRequest(requestMethod);

        this.response = given()
                .config(config)
                .headers(this.headers)
                .params(this.body)
                .when()
                .post(this.url)
                .then()
                .extract()
                .response();

        printResponse();

        return response;
    }

    public Response patch() {
        String requestMethod = "PATCH";
        RestAssured.defaultParser = Parser.JSON;
        this.useRelaxedHttpsValidation();

        RestAssuredConfig config = this.useCurlLogging();

        printRequest(requestMethod);

        this.response = given()
                .config(config)
                .headers(this.headers)
                .params(this.body)
                .when()
                .patch(this.url)
                .then()
                .extract()
                .response();

        printResponse();

        return response;
    }

    public Response delete() {
        String requestMethod = "DELETE";
        RestAssured.defaultParser = Parser.JSON;
        this.useRelaxedHttpsValidation();

        RestAssuredConfig config = this.useCurlLogging();

        printRequest(requestMethod);

        this.response = given()
                .config(config)
                .headers(this.headers)
                .params(this.body)
                .when()
                .delete(this.url)
                .then()
                .extract()
                .response();

        printResponse();

        return response;
    }

    public Response get() {
        String requestMethod = "GET";
        RestAssured.defaultParser = Parser.JSON;
        this.useRelaxedHttpsValidation();

        RestAssuredConfig config = this.useCurlLogging();

        printRequest(requestMethod);

        this.response = given()
                .config(config)
                .headers(this.headers)
                .when()
                .get(this.url)
                .then()
                .extract()
                .response();

        printResponse();

        return response;
    }

    protected void printRequest(String requestMethod) {
        String requestInfo = "Request:" +
                "\n  Method: " + requestMethod +
                "\n  URL: " + this.url +
                "\n  User-Agent: " + this.userAgent;

        if (this.headers != null && !this.headers.isEmpty()) {
            requestInfo += "\n  Headers: " + Arrays.toString(headers.entrySet().toArray());
        }

        if (this.cookies != null) {
            requestInfo += "\n  Cookie: " + this.cookies;
        }

        if (this.bodyString != null && !this.bodyString.isEmpty()) {
            JSONObject json;
            try {
                json = new JSONObject(this.bodyString);
                requestInfo += "\n  Body:\n" + json.toString(4).replaceAll("(?m)^", "    ");
            } catch (JSONException je) {
                requestInfo += "\n  Body:\n" + this.bodyString.replaceAll("(?m)^", "    ");
            }
        } else if (!this.body.isEmpty()) {
            requestInfo += "\n  Body: \n" + Arrays.toString(this.body.entrySet().toArray()).replaceAll("(?m)^", "    ");
        }

        logger.info(requestInfo);
    }

    protected void printResponse() {
        String responseInfo = "Response:" +
                "\n  Content Type: " + this.response.getContentType() +
                "\n  Status Code: " + this.response.getStatusCode() +
                "\n  Status Line: " + this.response.getStatusLine() +
                "\n  Time: " + this.response.getTime() + "ms";

        if (this.response.getCookies() != null && !this.response.getCookies().isEmpty()) {
            responseInfo += "\n  Cookies: \n" + this.response.getCookies().toString().replaceAll("(?m)^", "    ");
            responseInfo += "\n  Detailed Cookies: " + this.response.getDetailedCookies().toString().replaceAll("(?m)^", "    ");
        }

        if (this.response.getHeaders().toString() != null && !this.response.getHeaders().toString().isEmpty()) {
            responseInfo += "\n  Headers: \n" + this.response.getHeaders().toString().replaceAll("(?m)^", "    ");
        }

        String responseString = this.response.getBody().asString();
        if (this.response.getContentType().contains("application/json")) {
            JSONObject json;
            try {
                json = new JSONObject(responseString);
                responseInfo += "\n  Body:\n" + json.toString(4).replaceAll("(?m)^", "    ");
            } catch (JSONException je) {
                responseInfo += "\n  Body:\n" + responseString.replaceAll("(?m)^", "    ");
            }
        } else if (responseString != null && !responseString.isEmpty()) {
            responseInfo += "\n  Body:\n" + responseString.replaceAll("(?m)^", "    ");
        }

        logger.info(responseInfo);
    }
}

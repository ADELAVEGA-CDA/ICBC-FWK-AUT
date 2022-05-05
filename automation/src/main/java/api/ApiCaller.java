package api;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiCaller extends ApiBaseCaller {
    private static String validRequest = "{\n" +
            "  \"username\": \"test-api-user\",\n" +
            "  \"email\": \"test-api-user@email.com\",\n" +
            "  \"password\": \"Passw0rd123!\",\n" +
            "  \"name\": \"Test Api-User\" \n}";

    public Response getWithCookies() {
        String requestMethod = "GET";
        RestAssured.defaultParser = Parser.JSON;
        useRelaxedHttpsValidation();

        RestAssuredConfig config = useCurlLogging();

        // Print Request
        printRequest(requestMethod);

        response = given()
                .config(config)
                .cookies(cookies)
                .headers(headers)
                .params(body)
                .when()
                .get(url)
                .then()
                .extract()
                .response();

        // Print Response
        printResponse();

        return response;
    }

    public Response createUser() {
        String requestMethod = "GET";
        RestAssured.defaultParser = Parser.JSON;
        useRelaxedHttpsValidation();

        RestAssuredConfig config = useCurlLogging();

        // Print Request
        printRequest(requestMethod);

        response = given()
                .auth()
                .preemptive()
                .basic("MY_USERNAME", "MY_PASSWORD")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(validRequest)
                .post(url)
                .then().extract().response();

        // Print Response
        printResponse();

        return response;
    }

    public Response postWithCookiesAndJsonBody() {
        String requestMethod = "POST";
        RestAssured.defaultParser = Parser.JSON;
        useRelaxedHttpsValidation();

        RestAssuredConfig config = useCurlLogging();

        // Print Request
        printRequest(requestMethod);

        response = given()
                .config(config)
                .cookies(cookies)
                //.headers("User-Agent", userAgent)
                .headers(headers)
                .body(bodyString)
                .when()
                .post(url)
                .then()
                //.contentType(ContentType.JSON)
                //.statusCode(200)
                .extract()
                .response();

        // Print Response
        printResponse();

        return response;
    }

    public Response postWithJsonBody() {
        String requestMethod = "POST";
        RestAssured.defaultParser = Parser.JSON;
        useRelaxedHttpsValidation();

        RestAssuredConfig config = useCurlLogging();

        // Print Request
        printRequest(requestMethod);

        response = given()
                .config(config)
                .headers(headers)
                .body(bodyString)
                .when()
                .post(url)
                .then()
                .extract()
                .response();

        // Print Response
        printResponse();

        return response;
    }

    public Response deleteWithJsonBody() {
        String requestMethod = "DELETE";
        RestAssured.defaultParser = Parser.JSON;
        useRelaxedHttpsValidation();

        RestAssuredConfig config = useCurlLogging();

        // Print Request
        printRequest(requestMethod);

        response = given()
                .config(config)
                .headers(headers)
                .body(bodyString)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();

        // Print Response
        printResponse();

        return response;
    }

    public Response postWithJsonParams(JSONObject requestParams) {
        String requestMethod = "POST";
        useRelaxedHttpsValidation();

        printRequest(requestMethod);

//        JSONObject requestParams = new JSONObject();
//        requestParams.put("UserName", user);
//        requestParams.put("Password", pass);

        response = given()
                .header("Content-Type", "application/json") // Add the Json to the body of the request
                .body(requestParams.toString(1))
                .post(url)
                .then()
                .extract()
                .response();

        // Print Response
        printResponse();

        return response;
    }

    public Response putWithJsonBody() {
        String requestMethod = "PUT";
        RestAssured.defaultParser = Parser.JSON;
        this.useRelaxedHttpsValidation();

        RestAssuredConfig config = this.useCurlLogging();

        // Print Request
        printRequest(requestMethod);

        this.response = given()
                .config(config)
                .headers(this.headers)
                .body(this.bodyString)
                .when()
                .put(this.url)
                .then()
                .extract()
                .response();

        // Print Response
        printResponse();

        return response;
    }

    public void ConnectWithProxy() {
        RestAssured.useRelaxedHTTPSValidation(); //ignorar SSL
        RestAssured.proxy("localhost");//añadir un proxy
        RestAssured.proxy(8888); // añadir un puerto al proxy
    }
}

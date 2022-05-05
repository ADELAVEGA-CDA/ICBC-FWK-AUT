package api;

import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Base64;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiManager {
    public static String clientId = "";
    public static String redirectUri = "";
    public static String scope = "";
    public static String userName = "";
    public static String password = "";
    public static String grantType;

    public static String encode(String str1, String str2) {
        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
    }

    public static Response getCode() {
        String authorization = encode(userName, password);

        return
                given()
                        .header("authorization", "Basic " + authorization)
                        .contentType(ContentType.URLENC)
                        .formParam("response_type", "code")
                        .queryParam("client_id", clientId)
                        .queryParam("redirect_uri", redirectUri)
                        .queryParam("scope", scope)
                        .post("/oauth/authorize")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }

    public static String parseFor0AuthCode(Response response) {
        return response.jsonPath().getString("code");
    }

    public static Response getToken(String authCode) {
        String authorization = encode(userName, password);

        return given()
                .header("authorization", "Basic " + authorization)
                .contentType(ContentType.URLENC)
                .formParam("response_type", authCode)
                .queryParam("redirect_uri", redirectUri)
                .queryParam("grant_type", grantType)
                .post("/oauth/token")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static String parseForToken(Response loginResponse) {
        return loginResponse.jsonPath().getString("access_token");
    }

    public void SOAPRequest() {
        String xmlEnvelope = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
                "<soap12:Body>" + "<Define xmlns=\"http://services.aonaware.com/webservices/\">" +
                "<word></word>" +
                "</Define>" +
                "</soap12:Body>" +
                "</soap12:Envelope>";
        given()
                .header("SOAPAction", "Define")
                .baseUri("https://api.blogEjemplo.com")
                .when()
                .body(xmlEnvelope)
                .post("/endpoint");
    }

    public void basicAuth(String userName, String password) {
        given()
                .auth().basic(userName, password)
                .when()
                .get("AUTH_ENDPOINT")
                .then()
                .assertThat().statusCode(200);
    }

    public void preemptiveAuth(String userName, String password) {
        given().auth().preemptive().basic(userName, password).get(redirectUri);
    }

    public void formDigest(String userName, String password) {
        given().auth().digest(userName, password).get(redirectUri);
    }

    public void formAuthConfig(String userName, String password) {
        given().auth().form(userName, password, new FormAuthConfig("/perform_signIn",
                "user", "password"));
    }

    public void formAuth(String userName, String password) {
        given().auth().form(userName, password).when().get("SERVICE").then().assertThat().statusCode(200);
    }

    public void formOAuth1(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
        given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).get(redirectUri);
    }

    public void formOAuth2(String accessToken) {
        given().auth().oauth2(accessToken).get(redirectUri);
    }

    public Response getResponse(String path) {
        Response response = when().get(path).then().using().extract().response();
        return response;
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}

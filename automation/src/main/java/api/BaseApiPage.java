package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApiPage {
    public String USER_ID;
    public String USERNAME;
    public String PASSWORD;
    public String BASE_URL;
    public String BASE_URI;

    public String token;
    public Response response;
    public RequestSpecification request;

    public void setupRestAssured() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = new RequestSpecBuilder().
                addHeader("Content-Type", ContentType.JSON.toString()).
                addHeader("Accept", ContentType.JSON.toString()).
                build();
        RestAssured.requestSpecification = requestSpecification;
    }

    public String setupURI() {
        response = request
                .when()
                .get(BASE_URI);

        return response.asString();
    }
}

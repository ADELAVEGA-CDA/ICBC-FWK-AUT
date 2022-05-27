package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

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

        List<Filter> filterList = new ArrayList<>();
        filterList.add(new RequestLoggingFilter());
        filterList.add(new ResponseLoggingFilter());
        filterList.add(new AllureRestAssured());

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addFilters(filterList)
                .addHeader("Content-Type", ContentType.JSON.toString())
                .addHeader("Accept", ContentType.JSON.toString())
                .build();
    }

    public String setupURI() {
        response = request
                .when()
                .get(BASE_URI);

        return response.asString();
    }
}

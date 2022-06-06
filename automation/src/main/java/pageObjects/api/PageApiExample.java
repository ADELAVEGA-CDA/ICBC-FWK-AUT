package pageObjects.api;

import api.BaseApiPage;
import api.pojo.AuthorizationRequest;
import api.utils.ApiCaller;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageApiExample extends BaseApiPage {
    public static String jsonString;
    public static String bookId;
    public ApiCaller apiCaller;

    public PageApiExample() {
        apiCaller = new ApiCaller();
    }

    public void AuthorizedUser() {
        request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");
    }

    public void BooksAvailable() {
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

        bookId = books.get(0).get("isbn");
    }

    public void AddBook() {
        apiCaller.url = "/BookStore/v1/Books";

        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);
        header.put("Content-Type", "application/json");
        apiCaller.setHeaders(header);

        apiCaller.bodyString = "{ \"userId\": \"" + USER_ID + "\", " +
                "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}";
        apiCaller.postWithJsonBody();
    }

    public void DeleteBook() {
        apiCaller.url = "/BookStore/v1/Books";

        apiCaller.bodyString = "{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}";
        apiCaller.deleteWithJsonBody();
    }

    public void BookIsRemoved() {
        apiCaller.url = "/Account/v1/User/" + USER_ID;
        response = apiCaller.get();
        jsonString = response.asString();
    }

    public void BookSuccessfullyIsRemoved() {
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());
    }

    public void AuthorizedUserWithPojo() {
        AuthorizationRequest authRequest = new AuthorizationRequest(USERNAME, PASSWORD);

        request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body(authRequest).post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");
    }
}

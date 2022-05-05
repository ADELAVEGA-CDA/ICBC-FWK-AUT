package api;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Books extends BaseApiPage {
    @Test
    void getBooksList() {
        Response response = get("/books");

        ArrayList<String> allBooks = response.path("data.title");
        Assert.assertTrue("No books returned", allBooks.size() > 1);
    }

    @Test
    void booksSchemaIsValid() {
        get("/books")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("books Schema.json"));
    }

    @Test
    void createAndDeleteBook() throws URISyntaxException {
        File bookFile = new File(getClass().getResource("/book.json").toURI());
        Response createResponse =
                given()
                        .body(bookFile)
                        .when()
                        .post("/books");
        String responseID = createResponse.jsonPath().getString("post.book_id");
        Response deleteResponse =
                given()
                        .body("{\n" +
                                "\t\"book_id\": " + responseID + "\n" +
                                "}")
                        .when()
                        .delete("/books");

        Assert.assertEquals(deleteResponse.getStatusCode(), 200);
        Assert.assertEquals(deleteResponse.jsonPath().getString("message"), "Book successfully deleted");
    }

    @Test
    void deleteNonExistentBook_FailMessage() {
        String nonExistentBookID = "456123";
        Response deleteResponse =
                given()
                        .body("{\n" +
                                "\t\"book_id\": " +
                                nonExistentBookID + "\n" +
                                "}")
                        .when()
                        .delete("/books");

        Assert.assertEquals(deleteResponse.getStatusCode(), 500);
        Assert.assertEquals(deleteResponse.jsonPath().getString("error"), "Unable to find book id: " +
                nonExistentBookID);

    }


}

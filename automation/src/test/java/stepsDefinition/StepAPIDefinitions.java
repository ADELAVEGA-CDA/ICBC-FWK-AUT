package stepsDefinition;

import base.GlobalParams;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.api.PageApiExample;

public class StepAPIDefinitions {
    TestContext tst;
    GlobalParams param;
    PageApiExample pageApi;

    public StepAPIDefinitions(TestContext context) {
        tst = context;
        pageApi = new PageApiExample();
    }

    @Given("^I am an authorized user$")
    public void iAmAnAuthorizedUser() {
        pageApi.BASE_URL = "https://bookstore.toolsqa.com";
        pageApi.setupRestAssured();

        pageApi.USERNAME = "TOOLSQA-Test";
        pageApi.PASSWORD = "Test@@123";
        pageApi.AuthorizedUser();
    }

    @Given("^A list of books are available$")
    public void aListOfBooksAreAvailable() {
        pageApi.BASE_URI = "/BookStore/v1/Books";
        pageApi.jsonString = pageApi.setupURI();

        pageApi.BooksAvailable();
    }

    @When("^I add a book to my reading list$")
    public void iAddABookToMyReadingList() {
        pageApi.USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        pageApi.AddBook();
    }

    @Then("^the book is added$")
    public void theBookIsAdded() {
        Assert.assertEquals(201, pageApi.response.getStatusCode());
    }

    @When("^I remove a book from my reading list$")
    public void iRemoveABookFromMyReadingList() {
        pageApi.DeleteBook();
    }

    @Then("^the book is removed$")
    public void theBookIsRemoved() {
        Assert.assertEquals(204, pageApi.response.getStatusCode());
        pageApi.BookIsRemoved();

        Assert.assertEquals(200, pageApi.response.getStatusCode());
        pageApi.BookSuccessfullyIsRemoved();
    }

    @Given("^I am an authorized user with POJO$")
    public void iAmAnAuthorizedUserWithPojo() {
        pageApi.BASE_URL = "https://bookstore.toolsqa.com";
        pageApi.AuthorizedUser();
        pageApi.setupRestAssured();

        pageApi.USERNAME = "TOOLSQA-Test";
        pageApi.PASSWORD = "Test@@123";
        pageApi.AuthorizedUserWithPojo();
    }
}

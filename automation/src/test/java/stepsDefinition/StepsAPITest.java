package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepsAPITest {
    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^el sitio: \"([^\"]*)\"$")
    public void elSitio(String url) throws Throwable {
        request = given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .header("", "")
                .header("", "")
                .baseUri(url)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @When("^envío un GET request a la URI \"([^\"]*)\"$")
    public void envíoUnGETRequestALaURI(String uri) throws Throwable {
        request
                .when()
                .get(uri);
    }

    @When("^envío un POST request a la URI \"([^\"]*)\"$")
    public void envíoUnPOSTRequestALaURI(String uri) throws Throwable {
        response = request
                .when()
                .body("")
                .post(uri)
                .prettyPeek();
    }

    @Then("^obtengo (\\d+) como respuesta$")
    public void obtengoComoRespuesta(int responseCode) throws Throwable {
        json = response.then().statusCode(responseCode);
    }

    @Then("^valido que hay (\\d+) items")
    public void validoQueHayItemsEnElEndpoint(int items) throws Throwable {
        List<String> jsonResponse = response.jsonPath().getList("$");
        int actualSize = jsonResponse.size();

        assertEquals(items, actualSize);
    }
}

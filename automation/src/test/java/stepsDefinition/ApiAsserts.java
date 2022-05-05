package stepsDefinition;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class ApiAsserts {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    public void assertStatusCode(Response response, String expectedCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedCode);
    }

    public void statusAndResponse(Response response) {
        logger.info("Status received => " + response.getStatusLine());
        logger.info("Response=>" + response.prettyPrint());
        logger.info("Response Body is =>  " + response.asString());
    }
}

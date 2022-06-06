package base;

import context.TestContext;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GlobalRest {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    private RequestSpecification _request;
    private Response _response;
    private Boolean blnFlag = true;
    GlobalParams param;

    public GlobalRest() {
        param = TestContext.getGlobalParams();
    }

    public Response response() {
        baseURI = param.getURL();
        logger.info(param.getURL());
        _request = given();

        int matrixLenght = param.getMatrixLenght();
        if (matrixLenght == 0) {
            blnFlag = false;
            logger.warn(">> IMPLEMENT NEW HEADER CASE <<");
        } else {
            for (int i = 0; i < matrixLenght; i++) {
                _request.header(param.getMatrix(i, 0), param.getMatrix(i, 1));
                logger.info("Case " + param.getMatrix(i, 0) + " | " + param.getMatrix(i, 1));
            }
        }

        if (!blnFlag) {
            logger.warn(">> Flag isn't true <<");
            return _response;
        }

        if (param.getBODY() != null)
            _request.body(param.getBODY());

        if (param.getPARAMS() == null)
            _response = _request.post(param.getAPI());
        else
            _response = _request.post(param.getAPI() + param.getPARAMS());

        logger.info(">> Response: " + _response);

        return _response;
    }

    public int responseCode() {
        logger.info(param.getURL());
        baseURI = "https://demoqa.com";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        Response response = request.body("{ \"userName\": " + param.getString() + ", \"password\": " +
                        param.getStringB() + "}")
                .post(param.getAPI());
        return response.getStatusCode();
    }
}

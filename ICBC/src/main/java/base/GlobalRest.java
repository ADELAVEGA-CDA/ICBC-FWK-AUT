package base;

import context.TestContext;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GlobalRest {

    private RequestSpecification _request;
    private Response _response;
    private Boolean blnFlag = true;
    GlobalParams param;
    TestContext tstContext;

    public GlobalRest() {
        tstContext = new TestContext();
        param = tstContext.getPageObjMng().getGlobalParams();
    }

    public Response response() {
        // PARAMS CONECTION
        System.out.println(param.getURL());
        baseURI = param.getURL();
        _request = given();

        // SET DATA HEADER
        switch (param.getMatrixLenght()) {
            case 1:
                _request.header(param.getMatrix(0, 0), param.getMatrix(0, 1));
                System.out.println("Case 1 " + param.getMatrix(0, 0) + " | " + param.getMatrix(0, 1));
                break;
            case 2:
                _request.header(param.getMatrix(0, 0), param.getMatrix(0, 1))
                        .header(param.getMatrix(1, 0), param.getMatrix(1, 1));
                System.out.println("Case 2 " + param.getMatrix(1, 0) + " | " + param.getMatrix(1, 1));
                break;
            case 3:
                _request.header(param.getMatrix(0, 0), param.getMatrix(0, 1))
                        .header(param.getMatrix(1, 0), param.getMatrix(1, 1))
                        .header(param.getMatrix(2, 0), param.getMatrix(2, 1));
                System.out.println("Case 3 " + param.getMatrix(2, 0) + " | " + param.getMatrix(2, 1));
                break;
            default:
                blnFlag = false;
                System.out.println(">> IMPLEMENT NEW HEADER CASE <<");
        }

        // SET PARAMETERS: BODY OR NOT, PARAM TO API OR NOT
        if (!blnFlag) {
            System.out.println(">> Flag isn't true <<");
        } else if (param.getBODY() != null && param.getPARAMS() == null) {
            System.out.println(">> ElseIf 1 " + param.getBODY() + " | " + param.getAPI());
            _response = _request.body(param.getBODY())
                    .post(param.getAPI());
        } else if (param.getBODY() != null && param.getPARAMS() != null) {
            System.out.println(">> ElseIf 2 " + param.getBODY() + " | " + param.getPARAMS() + " | " + param.getAPI());
            _response = _request.body(param.getBODY())
                    .post(param.getAPI() + param.getPARAMS());
        } else if (param.getBODY() == null && param.getPARAMS() == null) {
            System.out.println(">> ElseIf 3 " + param.getAPI());
            _response = _request.post(param.getAPI());
        } else if (param.getBODY() == null && param.getPARAMS() != null) {
            System.out.println(">> ElseIf 4 " + param.getPARAMS() + " | " + param.getAPI());
            _response = _request.post(param.getAPI() + param.getPARAMS());
        } else {
            System.out.println(">> IMPLEMENT NEW ELSE IF PARAMS & BODY");
        }

        // RETURN RESPONSE
        return _response;
    }

    public int responseCode() {
        System.out.println(param.getURL());
        baseURI = "https://demoqa.com";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        Response response = request.body("{ \"userName\": " + param.getString() + ", \"password\": " + param.getString() + "}")
                .post(param.getAPI());
        return response.getStatusCode();
    }
}

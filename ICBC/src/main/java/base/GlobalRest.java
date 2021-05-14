package base;

import context.TestContext;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GlobalRest {

	private RequestSpecification _request;
	private Response _response;
	private Boolean blnFlag=true;
	GlobalParams param;
	TestContext tstContext;
	
	public GlobalRest() {
		tstContext=new TestContext();
		param=tstContext.getPageObjMng().getGlobalParams();
	}
	
	public Response response() {
		
		// CONECTION
		System.out.println(param.getURL());
		RestAssured.baseURI=param.getURL();
		_request = RestAssured.given();
		
		// SET HEADER
		switch (param.getArrBidLenght()) {
			case 1:
				_request.header(param.getArrBid(0,0),param.getArrBid(0,1));
				System.out.println("Case 1 "+param.getArrBid(0,0)+" | "+param.getArrBid(0,1));
				break;
			case 2:
				_request.header(param.getArrBid(0,0),param.getArrBid(0,1))
				.header(param.getArrBid(1,0),param.getArrBid(1,1));
				System.out.println("Case 2 "+param.getArrBid(1,0)+" | "+param.getArrBid(1,1));
				break;
			case 3:
				_request.header(param.getArrBid(0,0),param.getArrBid(0,1))
				.header(param.getArrBid(1,0),param.getArrBid(1,1))
				.header(param.getArrBid(2,0),param.getArrBid(2,1));
				System.out.println("Case 3 "+param.getArrBid(2,0)+" | "+param.getArrBid(2,1));
				break;
			default:
				blnFlag=false;
				System.out.println(">> IMPLEMENT NEW HEADER CASE <<");
		}

		// SET PARAMETERS: BODY OR NOT, PARAM TO API OR NOT
		if (!blnFlag) {
			System.out.println(">> Flag isn't true <<");
		} else if (param.getBODY()!=null&&param.getPARAMS()==null) {
			System.out.println(">> ElseIf 1 "+param.getBODY()+" | "+param.getAPI());
			_response=_request.body(param.getBODY())
					.post(param.getAPI());
		} else if (param.getBODY()!=null&&param.getPARAMS()!=null){
			System.out.println(">> ElseIf 2 "+param.getBODY()+" | "+param.getPARAMS()+" | "+param.getAPI());
			_response=_request.body(param.getBODY())
					.post(param.getAPI()+param.getPARAMS());
		} else if (param.getBODY()==null&&param.getPARAMS()==null) {	
			System.out.println(">> ElseIf 3 "+param.getAPI());
			_response=_request.post(param.getAPI());
		} else if (param.getBODY()==null&&param.getPARAMS()!=null) {
			System.out.println(">> ElseIf 4 "+param.getPARAMS()+" | "+param.getAPI());
			_response=_request.post(param.getAPI()+param.getPARAMS());
		} else {
			System.out.println(">> IMPLEMENT NEW ELSE IF PARAMS & BODY");
		}
		
		// RETURN RESPONSE
		return _response;
	}
	
}

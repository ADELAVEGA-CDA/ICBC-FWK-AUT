package base;

import context.TestContext;
import enums.Context;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import cucumber.api.DataTable;

public class GlobalParams {

	TestContext tstContext;
	private RequestSpecification _request;
	private Response _response;
	private Boolean blnFlag=true;
	
	public GlobalParams() {
		tstContext=new TestContext();}
	
	// INPUT
	public void setString_A(String _stringA) {
		tstContext.getScenarioContext().setContext(Context.DATA_INFO_A,_stringA);}
	public void setString_B(String _stringB) {
		tstContext.getScenarioContext().setContext(Context.DATA_INFO_B,_stringB);}
	public void setInt_1(int _int1) {
		tstContext.getScenarioContext().setContext(Context.DATA_NUMBER_1,_int1);}
	public void setInt_2(int _int2) {
		tstContext.getScenarioContext().setContext(Context.DATA_NUMBER_2,_int2);}
	public void setDataTable_1(DataTable _dt1) {
		tstContext.getScenarioContext().setContext(Context.DATA_TABLE,_dt1);}
	public void setArray(String[] _arr1) {
		tstContext.getScenarioContext().setContext(Context.DATA_ARRAY,_arr1);}
	public void setArraBid(String[][] _arr2) {
		tstContext.getScenarioContext().setContext(Context.DATA_ARRAY_BID,_arr2);}
	public void setURL(String _url) {
		tstContext.getScenarioContext().setContext(Context.URL,_url);}
	public void setAPI(String _api) {
		tstContext.getScenarioContext().setContext(Context.API,_api);}
	public void setBODY(String _body) {
		tstContext.getScenarioContext().setContext(Context.BODY,_body);}
	public void setPARAMS(String _params) {
		tstContext.getScenarioContext().setContext(Context.PARAM,_params);}
	
	// OUTPUT
	public String getString_A() {
		return (String) tstContext.getScenarioContext().getContext(Context.DATA_INFO_A);}
	public String getString_B() {
		return (String) tstContext.getScenarioContext().getContext(Context.DATA_INFO_B);}
	public int getInt_1() {
		return (int) tstContext.getScenarioContext().getContext(Context.DATA_NUMBER_1);}
	public int getInt_2() {
		return (int) tstContext.getScenarioContext().getContext(Context.DATA_NUMBER_2);}
	public DataTable getDataTable_1() {
		return (DataTable) tstContext.getScenarioContext().getContext(Context.DATA_TABLE);}
	public int getArrayLenght() {
		String[] _arr=(String[]) tstContext.getScenarioContext().getContext(Context.DATA_ARRAY);
		return _arr.length;}
	public String getArray(int x) {
		String[] _arr=(String[]) tstContext.getScenarioContext().getContext(Context.DATA_ARRAY);
		return _arr[x];}
	public int getArrBidLenght() {
		String[][] _arr=(String[][]) tstContext.getScenarioContext().getContext(Context.DATA_ARRAY_BID);
		return _arr.length;}
	public String getArrBid(int x, int z) {
		String[][] _arr=(String[][]) tstContext.getScenarioContext().getContext(Context.DATA_ARRAY_BID);
		return _arr[x][z];}
	public String getURL() {
		return (String) tstContext.getScenarioContext().getContext(Context.URL);}
	public String getAPI() {
		return (String) tstContext.getScenarioContext().getContext(Context.API);}
	public String getBODY() {
		return (String) tstContext.getScenarioContext().getContext(Context.BODY);}
	public String getPARAMS() {
		return (String) tstContext.getScenarioContext().getContext(Context.PARAM);}
		
	// REST ASSURED RESPONSE API
	public Response responseRest() {
		// CONECTION
		System.out.println(this.getURL());
		RestAssured.baseURI=this.getURL();
		_request = RestAssured.given();
		// SET HEADER
		switch (this.getArrBidLenght()) {
			case 1:
				_request.header(this.getArrBid(0,0),this.getArrBid(0,1));
				System.out.println("Case 1 "+this.getArrBid(0,0)+" | "+this.getArrBid(0,1));
				break;
			case 2:
				_request.header(this.getArrBid(0,0),this.getArrBid(0,1))
				.header(this.getArrBid(1,0),this.getArrBid(1,1));
				System.out.println("Case 2 "+this.getArrBid(1,0)+" | "+this.getArrBid(1,1));
				break;
			case 3:
				_request.header(this.getArrBid(0,0),this.getArrBid(0,1))
				.header(this.getArrBid(1,0),this.getArrBid(1,1))
				.header(this.getArrBid(2,0),this.getArrBid(2,1));
				System.out.println("Case 3 "+this.getArrBid(2,0)+" | "+this.getArrBid(2,1));
				break;
			default:
				blnFlag=false;
				System.out.println(">> IMPLEMENT NEW HEADER CASE <<");
		}

		// SET PARAMETERS: BODY OR NOT, PARAM TO API OR NOT
		if (!blnFlag) {
			System.out.println(">> Flag isn't true <<");
		} else if (this.getBODY()!=null&&this.getPARAMS()==null) {
			System.out.println(">> ElseIf 1 "+this.getBODY()+" | "+this.getAPI());
			_response=_request.body(this.getBODY())
					.post(this.getAPI());
		} else if (this.getBODY()!=null&&this.getPARAMS()!=null){
			System.out.println(">> ElseIf 2 "+this.getBODY()+" | "+this.getPARAMS()+" | "+this.getAPI());
			_response=_request.body(this.getBODY())
					.post(this.getAPI()+this.getPARAMS());
		} else if (this.getBODY()==null&&this.getPARAMS()==null) {	
			System.out.println(">> ElseIf 3 "+this.getAPI());
			_response=_request.post(this.getAPI());
		} else if (this.getBODY()==null&&this.getPARAMS()!=null) {
			System.out.println(">> ElseIf 4 "+this.getPARAMS()+" | "+this.getAPI());
			_response=_request.post(this.getAPI()+this.getPARAMS());
		} else {
			System.out.println(">> IMPLEMENT NEW ELSE IF PARAMS & BODY");
		}
		
		// RETURN RESPONSE
		return _response;
	}
}

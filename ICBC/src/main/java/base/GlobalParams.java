package base;

import context.TestContext;
import cucumber.api.DataTable;
import enums.Context;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GlobalParams {

    TestContext tstContext;
    private RequestSpecification _request;
    private Response _response;
    private Boolean blnFlag = true;

    public GlobalParams() {
        tstContext = new TestContext();
    }

    public void setArray(String[] _array) {
        tstContext.getScenarioContext().setContext(Context.DATA_ARRAY, _array);
    }

    public void setMatrix(String[][] _matrix) {
        tstContext.getScenarioContext().setContext(Context.DATA_MATRIX, _matrix);
    }

    // DATA OUTPUT
    public String getString() {
        return (String) tstContext.getScenarioContext().getContext(Context.DATA_INFO);
    }

    // DATA INPUT
    public void setString(String _string) {
        tstContext.getScenarioContext().setContext(Context.DATA_INFO, _string);
    }

    public int getInt() {
        return (int) tstContext.getScenarioContext().getContext(Context.DATA_NUMBER);
    }

    public void setInt(int _int) {
        tstContext.getScenarioContext().setContext(Context.DATA_NUMBER, _int);
    }

    public DataTable getDataTable() {
        return (DataTable) tstContext.getScenarioContext().getContext(Context.DATA_TABLE);
    }

    public void setDataTable(DataTable _dt) {
        tstContext.getScenarioContext().setContext(Context.DATA_TABLE, _dt);
    }

    public int getArrayLenght() {
        String[] _arr = (String[]) tstContext.getScenarioContext().getContext(Context.DATA_ARRAY);
        return _arr.length;
    }

    public String getArray(int x) {
        String[] _arr = (String[]) tstContext.getScenarioContext().getContext(Context.DATA_ARRAY);
        return _arr[x];
    }

    public int getMatrixLenght() {
        String[][] _arr=(String[][]) tstContext.getScenarioContext().getContext(Context.DATA_MATRIX);
        return _arr.length;
    }

    public String getMatrix(int x, int z) {
        String[][] _arr=(String[][]) tstContext.getScenarioContext().getContext(Context.DATA_MATRIX);
        return _arr[x][z];
    }

    public String getURL() {
        return (String) tstContext.getScenarioContext().getContext(Context.URL);
    }

    public void setURL(String _url) {
        tstContext.getScenarioContext().setContext(Context.URL, _url);
    }

    public String getAPI() {
        return (String) tstContext.getScenarioContext().getContext(Context.API);
    }

    public void setAPI(String _api) {
        tstContext.getScenarioContext().setContext(Context.API, _api);
    }

    public String getBODY() {
        return (String) tstContext.getScenarioContext().getContext(Context.BODY);
    }

    public void setBODY(String _body) {
        tstContext.getScenarioContext().setContext(Context.BODY, _body);
    }

    public String getPARAMS() {
        return (String) tstContext.getScenarioContext().getContext(Context.PARAM);
    }

    public void setPARAMS(String _params) {
        tstContext.getScenarioContext().setContext(Context.PARAM, _params);
    }
}

package base;

import context.TestContext;
import enums.Context;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GlobalParams {
    private RequestSpecification _request;
    private Response _response;
    private Boolean blnFlag = true;

    // DATA OUTPUT
    public String getString() {
        return (String) TestContext.getScenarioContext().getContext(Context.DATA_INFO);
    }

    // DATA INPUT
    public void setString(String _string) {
        TestContext.getScenarioContext().setContext(Context.DATA_INFO, _string);
    }

    public String getStringB() {
        return (String) TestContext.getScenarioContext().getContext(Context.DATA_INFO_B);
    }

    public void setStringB(String _string) {
        TestContext.getScenarioContext().setContext(Context.DATA_INFO_B, _string);
    }

    public int getInt() {
        return (int) TestContext.getScenarioContext().getContext(Context.DATA_NUMBER);
    }

    public void setInt(int _int) {
        TestContext.getScenarioContext().setContext(Context.DATA_NUMBER, _int);
    }

    public DataTable getDataTable() {
        return (DataTable) TestContext.getScenarioContext().getContext(Context.DATA_TABLE);
    }

    public void setDataTable(DataTable _dt) {
        TestContext.getScenarioContext().setContext(Context.DATA_TABLE, _dt);
    }

    public void setArray(String[] _array) {
        TestContext.getScenarioContext().setContext(Context.DATA_ARRAY, _array);
    }

    public String getArray(int x) {
        String[] _arr = (String[]) TestContext.getScenarioContext().getContext(Context.DATA_ARRAY);
        return _arr[x];
    }

    public int getArrayLenght() {
        String[] _arr = (String[]) TestContext.getScenarioContext().getContext(Context.DATA_ARRAY);
        return _arr.length;
    }

    public void setMatrix(String[][] _matrix) {
        TestContext.getScenarioContext().setContext(Context.DATA_MATRIX, _matrix);
    }

    public String getMatrix(int x, int z) {
        String[][] _arr = (String[][]) TestContext.getScenarioContext().getContext(Context.DATA_MATRIX);
        return _arr[x][z];
    }

    public int getMatrixLenght() {
        String[][] _arr = (String[][]) TestContext.getScenarioContext().getContext(Context.DATA_MATRIX);
        return _arr.length;
    }

    public String getURL() {
        return (String) TestContext.getScenarioContext().getContext(Context.URL);
    }

    public void setURL(String _url) {
        TestContext.getScenarioContext().setContext(Context.URL, _url);
    }

    public String getAPI() {
        return (String) TestContext.getScenarioContext().getContext(Context.API);
    }

    public void setAPI(String _api) {
        TestContext.getScenarioContext().setContext(Context.API, _api);
    }

    public String getBODY() {
        return (String) TestContext.getScenarioContext().getContext(Context.BODY);
    }

    public void setBODY(String _body) {
        TestContext.getScenarioContext().setContext(Context.BODY, _body);
    }

    public String getPARAMS() {
        return (String) TestContext.getScenarioContext().getContext(Context.PARAM);
    }

    public void setPARAMS(String _params) {
        TestContext.getScenarioContext().setContext(Context.PARAM, _params);
    }
}

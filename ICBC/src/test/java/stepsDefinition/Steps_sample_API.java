package stepsDefinition;

import base.GlobalParams;
import base.GlobalRest;
import context.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;

public class Steps_sample_API {

    TestContext tst;
    GlobalParams param;
    GlobalRest rest;

    public Steps_sample_API(TestContext context) {
        tst = context;
        param = tst.getPageObjMng().getGlobalParams();
		rest = tst.getPageObjMng().getGlobalRest();
    }

    @Given("^accedo a la url \"([^\"]*)\" de autorización$")
    public void accedo_a_la_url_de_autorización(String _url) throws Throwable {
        //
        param.setURL(_url);
    }

    @Given("^tengo el path de la api \"([^\"]*)\" de autorización$")
    public void tengo_el_path_de_la_api_de_autorización(String _api) throws Throwable {
        //
        param.setAPI(_api);
    }

    @When("^indico los datos para \"([^\"]*)\" y \"([^\"]*)\" del body de autorización$")
    public void indico_los_datos_para_y_del_body_de_autorización(String _user, String _pass) throws Throwable {
        //
        param.setString(_user);
        param.setString(_pass);
    }

    @Then("^obtengo el codigo (\\d+) como respuesta para autorización$")
    public void obtengo_el_codigo_como_respuesta_para_autorización(int _code) throws Throwable {
        //
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json").header("Content-Type", "application/json");
        Response response = request.body("{ \"userName\": " + "TOOLSQA-Test" + ", \"password\": " + "Test@@123" + "}")
                .post("/Account/v1/Authorized");
        System.out.println(response.getStatusCode());
    }


    @Given("^accedo a la url \"([^\"]*)\"$")
    public void accedo_a_la_url(String url) throws Throwable {
        param.setURL(url);
        System.out.println("Accedo a la url " + param.getURL());
    }

    @Given("^tengo el path de la api \"([^\"]*)\"$")
    public void tengo_el_path_de_la_api(String api) throws Throwable {
        param.setAPI(api);
        System.out.println("Tengo el path de la api " + param.getAPI());
    }

    @Given("^ingreso los paramatros \"([^\"]*)\"$")
    public void ingreso_los_paramatros(String params) throws Throwable {
        param.setPARAMS(params);
        System.out.println("Ingreso los paramatros " + param.getPARAMS());
    }

    @When("^ingreso los datos de usuario \"([^\"]*)\" y contraseña \"([^\"]*)\" del body$")
    public void ingreso_los_datos_de_usuario_y_contraseña_del_body(String user, String pass) throws Throwable {
        String _body = "{ \"userName\":\"" + user + "\", \"password\":\"" + pass + "\"}";
        param.setBODY(_body);
        System.out.println("Ingreso los datos del body " + param.getBODY());
    }

    @When("^indico la cabecera \"([^\"]*)\" y \"([^\"]*)\"$")
    public void indico_la_cabecera_y(String head1, String head2) throws Throwable {
        String[][] arrHeader = {{head1, head2}};
        param.setMatrix(arrHeader);
        System.out.println("Ingreso la cabecera " + param.getMatrix(0, 0) + " y " + param.getMatrix(0, 1));
    }

    @Then("^obtengo el codigo (\\d+) como respuesta$")
    public void obtengo_el_codigo_como_respuesta(int code) throws Throwable {
        param.setInt(code);
        System.out.println("Obtengo la respueta " + param.getInt());
        int _codeResponse = rest.response().getStatusCode();
        if (_codeResponse == param.getInt()) {
            System.out.println("Se obtuvo el codigo " + _codeResponse);
        } else {
            Assert.assertEquals(param.getInt(), _codeResponse);
        }
    }

    @When("^ingreso los datos del body$")
    public void ingreso_los_datos_del_body(DataTable body) throws Throwable {
        List<List<String>> _body = body.raw();
        param.setBODY("{\"" + _body.get(0).get(0) + "\":\"" + _body.get(0).get(1) + "\",\"" + _body.get(0).get(2) + "\":[{\"" + _body.get(0).get(3) + "\":\"" + _body.get(0).get(4) + "\"}]}");
        System.out.println(param.getBODY());
    }

    @When("^ingreso los datos de los paramatros$")
    public void ingreso_los_datos_de_los_paramatros() throws Throwable {

    }

    @When("^indico los datos de la cabecera api$")
    public void indico_los_datos_de_la_cabecera_api(DataTable header) throws Throwable {
        List<List<String>> _head = header.raw();
        int filas = header.raw().size();
        String[][] arrHead = new String[filas][2];
        for (int x = 0; x < filas; x++) {
            arrHead[x][0] = _head.get(x).get(0);
            arrHead[x][1] = _head.get(x).get(1);
            System.out.println(arrHead[x][0] + " : " + arrHead[x][1]);
        }
    }

    @Then("^obtengo el mensaje \"([^\"]*)\" de respuesta de \"([^\"]*)\"$")
    public void obtengo_el_mensaje_de_respuesta_de(String arg1, String arg2) throws Throwable {
        String mensaje = rest.response().asString();
        System.out.println("\n\nmensaje de respuesta\n\n" + mensaje);

    }

    @Then("^obtengo el codigo (\\d+) como respuesta de \"([^\"]*)\"$")
    public void obtengo_el_codigo_como_respuesta_de(int code, String apiTest) throws Throwable {
        param.setInt(code);
        System.out.println("Se espera por la respueta " + param.getInt());
        int _codeResponse = rest.response().getStatusCode();
        if (_codeResponse == param.getInt()) {
            System.out.println("Se obtuvo el codigo " + _codeResponse);
        } else {
            Assert.assertEquals(param.getInt(), _codeResponse);
        }
    }

}

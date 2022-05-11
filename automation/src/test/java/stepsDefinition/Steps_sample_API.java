package stepsDefinition;

import base.GlobalParams;
import base.GlobalRest;
import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.List;

public class Steps_sample_API {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    TestContext tst;
    GlobalParams param;
    GlobalRest rest;

    public Steps_sample_API(TestContext context) {
        tst = context;
        param = tst.getGlobalParams();
        rest = tst.getGlobalRest();
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
        param.setStringB(_pass);
    }

    @Then("^obtengo el codigo (\\d+) como respuesta para autorización$")
    public void obtengo_el_codigo_como_respuesta_para_autorización(int _code) throws Throwable {
        //
        rest.responseCode();
    }


    @Given("^accedo a la url \"([^\"]*)\"$")
    public void accedo_a_la_url(String url) throws Throwable {
        param.setURL(url);
        logger.info("Accedo a la url " + param.getURL());
    }

    @Given("^tengo el path de la api \"([^\"]*)\"$")
    public void tengo_el_path_de_la_api(String api) throws Throwable {
        param.setAPI(api);
        logger.info("Tengo el path de la api " + param.getAPI());
    }

    @Given("^ingreso los paramatros \"([^\"]*)\"$")
    public void ingreso_los_paramatros(String params) throws Throwable {
        param.setPARAMS(params);
        logger.info("Ingreso los paramatros " + param.getPARAMS());
    }

    @When("^ingreso los datos de usuario \"([^\"]*)\" y contraseña \"([^\"]*)\" del body$")
    public void ingreso_los_datos_de_usuario_y_contraseña_del_body(String user, String pass) throws Throwable {
        String _body = "{ \"userName\":\"" + user + "\", \"password\":\"" + pass + "\"}";
        param.setBODY(_body);
        logger.info("Ingreso los datos del body " + param.getBODY());
    }

    @When("^indico la cabecera \"([^\"]*)\" y \"([^\"]*)\"$")
    public void indico_la_cabecera_y(String head1, String head2) throws Throwable {
        String[][] arrHeader = {{head1, head2}};
        param.setMatrix(arrHeader);
        logger.info("Ingreso la cabecera " + param.getMatrix(0, 0) + " y " + param.getMatrix(0, 1));
    }

    @Then("^obtengo el codigo (\\d+) como respuesta$")
    public void obtengo_el_codigo_como_respuesta(int code) throws Throwable {
        param.setInt(code);
        logger.info("Obtengo la respueta " + param.getInt());
        int _codeResponse = rest.response().getStatusCode();
        if (_codeResponse == param.getInt()) {
            logger.info("Se obtuvo el codigo " + _codeResponse);
        } else {
            Assert.assertEquals(param.getInt(), _codeResponse);
        }
    }

    @When("^ingreso los datos del body$")
    public void ingreso_los_datos_del_body(DataTable body) throws Throwable {
        List<List<String>> _body = body.cells();
        param.setBODY("{\"" + _body.get(0).get(0) + "\":\"" + _body.get(0).get(1) + "\",\"" + _body.get(0).get(2) + "\":[{\"" + _body.get(0).get(3) + "\":\"" + _body.get(0).get(4) + "\"}]}");
        logger.info(param.getBODY());
    }

    @When("^ingreso los datos de los paramatros$")
    public void ingreso_los_datos_de_los_paramatros() throws Throwable {

    }

    @When("^indico los datos de la cabecera api$")
    public void indico_los_datos_de_la_cabecera_api(DataTable header) throws Throwable {
        List<List<String>> _head = header.cells();
        int filas = header.cells().size();
        String[][] arrHead = new String[filas][2];
        for (int x = 0; x < filas; x++) {
            arrHead[x][0] = _head.get(x).get(0);
            arrHead[x][1] = _head.get(x).get(1);
            logger.info(arrHead[x][0] + " : " + arrHead[x][1]);
        }
    }

    @Then("^obtengo el mensaje \"([^\"]*)\" de respuesta de \"([^\"]*)\"$")
    public void obtengo_el_mensaje_de_respuesta_de(String arg1, String arg2) throws Throwable {
        String mensaje = rest.response().asString();
        logger.info("\n\nmensaje de respuesta\n\n" + mensaje);

    }

    @Then("^obtengo el codigo (\\d+) como respuesta de \"([^\"]*)\"$")
    public void obtengo_el_codigo_como_respuesta_de(int code, String apiTest) throws Throwable {
        param.setInt(code);
        logger.info("Se espera por la respueta " + param.getInt());
        int _codeResponse = rest.response().getStatusCode();
        if (_codeResponse == param.getInt()) {
            logger.info("Se obtuvo el codigo " + _codeResponse);
        } else {
            Assert.assertEquals(param.getInt(), _codeResponse);
        }
    }

}

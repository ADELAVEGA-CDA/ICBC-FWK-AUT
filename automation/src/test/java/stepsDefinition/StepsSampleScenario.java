package stepsDefinition;

import base.GlobalParams;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pageObjects.PageSampleScenario;
import utils.DriverUtilities;

public class StepsSampleScenario {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    GlobalParams param;
    PageSampleScenario home;
    DriverUtilities driverUtils;

    public StepsSampleScenario() {
        this.home = new PageSampleScenario();
        this.driverUtils = new DriverUtilities();
    }

    @When("^hago clic en el menu Personas de la pagina Personas$")
    public void hagoClicEnElMenuPersonasDeLaPaginaPersonas() throws Throwable {
        //
        home.clicOnPersonas();
    }

    @When("^hago clic en la solapa Productos y Servicios de la pagina Personas$")
    public void hagoClicEnLaSolapaProductosYServiciosDeLaPaginaPersonas() throws Throwable {
        //
        home.clicOnProductos();
    }

    @When("^hago clic en la opcion Paquetes de la pagina Personas$")
    public void hagoClicEnLaOpcionPaquetesDeLaPaginaPersonas() throws Throwable {
        //
        home.clicOnPaquete();
    }

    @Then("^accedo a los productos y servicios de la pagina Paquetes$")
    public void accedoALosProductosYServiciosDeLaPaginaPaquetes() throws Throwable {
        //
        logger.info(driverUtils.getUrl());
        logger.info(driverUtils.getTitle());
    }

    @Then("^accedo a \"([^\"]*)\" de la pagina Paquetes$")
    public void accedoADeLaPaginaPaquetes(String title) throws Throwable {
        //
        Assert.assertEquals(title, driverUtils.getTitle());
        Assert.assertEquals("No coincide los titulos. Verificar. ", title, driverUtils.getTitle());
    }

    @Given("^accedo a la pagina principal$")
    public void accedoALaPaginaPrincipal() throws Throwable {
        logger.info("Dado que accedo a la pagina principal.");
    }

    @When("^busco un producto por \"([^\"]*)\" como descripcion$")
    public void buscoUnProductoPorComoDescripcion(String desc) throws Throwable {
        logger.info("Cuando busco un producto por " + desc + " como descripción.");
    }

    @When("^hago clic en el boton aceptar$")
    public void hagoClicEnElBotonAceptar() throws Throwable {
        logger.info("Cuando hago clic en el boton aceptar.");
    }

    @Then("^veo la lista de los productos$")
    public void veoLaListaDeLosProductos() throws Throwable {
        logger.info("Entonces veo la lista de los productos.");
    }
}

package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pageObjects.PageE2EScenario;

public class StepsE2EScenario {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    PageE2EScenario pageScenario;

    public StepsE2EScenario() {
        this.pageScenario = new PageE2EScenario();
    }

    @When("me dirijo a la sección de elementos")
    public void meDirijoALaSecciónDeElementos() {
        pageScenario.SeccionElementos();
    }

    @And("hago click en el apartado de Upload and Download")
    public void hagoClickEnElApartadoDeUploadAndDownload() {
        pageScenario.Apartado("Upload and Download");
    }

    @When("subo un archivo de la dirección: {string}")
    public void suboUnArchivoDeLaDirección(String dir) {
        pageScenario.SubirArchivo(dir);
    }

    @Then("el archivo {string} está subido en el servidor")
    public void elArchivoEstáSubidoEnElServidor(String fileName) {
        String path = pageScenario.PathDeSubida();
        Assert.assertTrue(path.contains(fileName));
    }
}

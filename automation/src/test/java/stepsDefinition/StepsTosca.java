package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ToscaToSeleniumPage;

public class StepsTosca {
    ToscaToSeleniumPage toscaPage;

    public StepsTosca(ToscaToSeleniumPage toscaPage) {
        this.toscaPage = toscaPage;
    }

    @When("ingreso por empresa con el CUIT {string}")
    public void ingresoPorEmpresaConElCUIT(String cuit) {
        toscaPage.IngresoCUIT(cuit);
    }

    @And("el nombre de usuario {string}")
    public void elNombreDeUsuario(String usuario) {
        toscaPage.Usuario(usuario);
    }

    @And("la contraseña {string}")
    public void laContrasenia(String pass) {
        toscaPage.Contrasenia(pass);
    }

    @And("me dirijo a Adminitración de usuarios con el código {string}")
    public void meDirijoAAdminitracionDeUsuariosConElCodigo(String codigo) {
        toscaPage.AdministracionUsuarios(codigo);
    }

    @And("me dirijo a Administración de empresas y Esquema de firmas")
    public void meDirijoAAdministracionDeEmpresasYEsquemaDeFirmas() {
        toscaPage.AdministracionEmpresas();
    }

    @Then("me muestra la pantalla de Esquema de firmas")
    public void meMuestraLaPantallaDeEsquemaDeFirmas() {
        toscaPage.EsquemaFirmas();
    }

    @Then("me logueo en el sitio correctamente")
    public void meLogueoEnElSitioCorrectamente() {
        toscaPage.LogueadoCorrectamente();
    }
}

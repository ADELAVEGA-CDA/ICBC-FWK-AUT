package pageObjects;

import driversManager.utils.DriverUtilities;
import managers.StartPagesMng;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ToscaToSeleniumPage extends StartPagesMng {
    private final DriverUtilities driverUtils;

    @FindBy(how = How.ID, using = "empresaNumDoc")
    private WebElement docEmpresa;
    @FindBy(how = How.ID, using = "username")
    private WebElement username;
    @FindBy(how = How.CSS, using = ".ng-tns-c18-20 > .btn")
    private WebElement btnUsuario;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement password;
    @FindBy(how = How.CSS, using = ".ng-tns-c18-20 > .btn-primary")
    private WebElement btnPassword;
    @FindBy(how = How.CSS, using = ".ng-star-inserted:nth-child(2) > .ng-tns-c1-34:nth-child(1)")
    private WebElement openFrame;
    @FindBy(how = How.CSS, using = ".nav > .ng-tns-c0-0:nth-child(1) > .ng-tns-c0-0")
    private WebElement submitFrame;
    @FindBy(how = How.LINK_TEXT, using = "Administración de usuarios")
    private WebElement adminUsuarios;
    @FindBy(how = How.CSS, using = ".form-control")
    private WebElement submitForm;
    @FindBy(how = How.CSS, using = ".action-buttons .ng-star-inserted")
    private WebElement insertedStar;
    @FindBy(how = How.ID, using = "Administración de empresas")
    private WebElement adminEmpresas;
    @FindBy(how = How.ID, using = "Esquema de firmas")
    private WebElement esquemaFirmas;

    public ToscaToSeleniumPage() {
        driverUtils = new DriverUtilities();
    }

    public void IngresoCUIT(String cuit) {
        docEmpresa.click();
        docEmpresa.sendKeys(cuit);
    }

    public void Usuario(String usuario) {
        username.click();
        username.sendKeys(usuario);
        btnUsuario.click();
    }

    public void Contrasenia(String pass) {
        password.click();
        password.sendKeys(pass);
        btnPassword.click();
    }

    public void AdministracionUsuarios(String codigo) {
        openFrame.click();
        driver.switchTo().frame(0);
        submitFrame.click();
        driver.switchTo().defaultContent();
        adminUsuarios.click();
        submitForm.sendKeys(codigo);
        insertedStar.click();
    }

    public void AdministracionEmpresas() {
        driver.switchTo().frame(0);
        adminEmpresas.click();
        esquemaFirmas.click();
    }

    public void EsquemaFirmas() {
        Assert.assertTrue(driverUtils.getTitle().contains("Esquema de Firmas"));
        log.info(":: The title of the site is: " + driverUtils.getTitle());
    }

    public void LogueadoCorrectamente() {
        Assert.assertTrue(driverUtils.getUrl().contains("/loginPage"));
        log.info(":: The page Url is: " + driverUtils.getUrl());
    }
}

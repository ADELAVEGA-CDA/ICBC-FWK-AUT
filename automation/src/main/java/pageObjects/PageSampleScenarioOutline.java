package pageObjects;

import managers.StartPagesMng;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageSampleScenarioOutline extends StartPagesMng {
    @FindBy(how = How.CSS, using = ".cssValue")
    private WebElement tbxName_check;
    @FindBy(how = How.XPATH, using = "//*[@ID='idValue']")
    private WebElement btnName_check;
    @FindBy(how = How.CSS, using = ".po-hea__search-open")
    private WebElement btnLupa;
    @FindBy(how = How.CSS, using = ".dijitInputInner")
    private WebElement tbxBuscar;
    @FindBy(how = How.XPATH, using = "//*[@ID='cabecera_busqueda']/span/strong[1]")
    private WebElement txtResultados;
    @FindBy(how = How.XPATH, using = "//ul[@class='po-faq__list clearlist']/li[1]")
    private WebElement liFAQ;
    @FindBy(how = How.CSS, using = ".po-hea__support-link")
    private WebElement btnContactanos;
    @FindBy(how = How.XPATH, using = "//ul[@class='po-tabs__nav']/li[5]")
    private WebElement btnInternet;
    @FindBy(how = How.XPATH, using = "//ul[@class='productList']/li[5]/label")
    private WebElement btnServicios;
    @FindBy(how = How.XPATH, using = "//ul[@class='productList step2']/li[@class='servicios show'][5]/label")
    private WebElement btnOtroServicios;
    @FindBy(how = How.CSS, using = ".form-control")
    private WebElement tbxDetalle;
    @FindBy(how = How.CSS, using = ".continue")
    private WebElement btnContinuar;
    @FindBy(how = How.CSS, using = ".po-hea__submenu-link")
    private WebElement btnSueldo;

    public void enterName(String name) {
        tbxName_check.sendKeys(name);
    }

    public void clickName() {
        btnName_check.click();
    }

    public void clic_Lupa() {
        btnLupa.click();
    }

    public void enter_Busqueda(String sBuscar) {
        tbxBuscar.sendKeys(sBuscar);
        tbxBuscar.sendKeys(Keys.ENTER);
    }

    public String get_Resultados() {
        liFAQ.click();
        return txtResultados.getText();
    }

    public void clic_Contactanos() {
        btnContactanos.click();
    }

    public void clic_Internet() {
        btnInternet.click();
    }

    public void clic_FormWeb() {
        driver.get("https://www.gestiondereclamos.icbc.com.ar/?utm_source=institucional&utm_medium=link&utm_campaign=reclamo");
    }

    public void clic_Servicos() {
        btnServicios.click();
    }

    public void clic_OtrosServicos() {
        btnOtroServicios.click();
    }

    public void enter_Detalle(String detalle) {
        tbxDetalle.sendKeys(detalle);
    }

    public void clic_Continuar() {
        btnContinuar.click();
    }

    public void clic_Sueldo() {
        btnSueldo.click();
    }

}

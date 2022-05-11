package pageObjects;

import managers.FileReaderMng;
import managers.StartPagesMng;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Page_sample_Scenario extends StartPagesMng {

    private Boolean _size = FileReaderMng.getInstance().getConfigReader().getBrowserSize();
    private String _url = FileReaderMng.getInstance().getConfigReader().getURL();

    // FIND BY HOW AND USING
    @FindBy(how = How.CSS, using = ".po-hea__menu-title")
    private WebElement btnPersonas;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'po-hea__submenu-item')][2]")
    private WebElement btnProductos;
    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'po-hea__subsubmenu-list')]/li[2]")
    private WebElement btnPaquete;

    // USE DEFINED ELEMENT
    public void clic_onPersonas() {
        btnPersonas.click();
    }

    public void clic_onProductos() {
        btnProductos.click();
    }

    public void clic_onPaquete() {
        wait.until(ExpectedConditions.visibilityOf(btnPaquete));
        btnPaquete.click();
    }

    public String get_Url() {
        return driver.getCurrentUrl();
    }

    public String get_Title() {
        return driver.getTitle();
    }

}

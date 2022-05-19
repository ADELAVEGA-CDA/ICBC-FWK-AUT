package pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import managers.StartPagesMng;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.time.Duration.ofSeconds;

public class PageSampleScenario extends StartPagesMng {
    // FIND BY HOW AND USING
    @AndroidFindBy(id = "com.android.chrome:id/infobar_close_button")
    private WebElement closeTranslate;
    @AndroidFindBy(xpath = "//button[@type='button']")
    @iOSXCUITFindBy(id = "UserName")
    private WebElement btnMenu;
    @AndroidFindBy(xpath = "//span[contains(text(),'Personas')]")
    @iOSXCUITFindBy(id = "UserName")
    @FindBy(how = How.CSS, using = ".po-hea__menu-title")
    private WebElement btnPersonas;
    @AndroidFindBy(xpath = "//a[contains(text(),'Productos')]")
    @iOSXCUITFindBy(id = "UserName")
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'po-hea__submenu-item')][2]")
    private WebElement btnProductos;
    @AndroidFindBy(xpath = "//a[contains(@href,'/paquetes')]")
    @iOSXCUITFindBy(id = "UserName")
    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'po-hea__subsubmenu-list')]/li[2]")
    private WebElement btnPaquete;

    public PageSampleScenario() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, ofSeconds(5)), this);
    }

    // USE DEFINED ELEMENT
    public void clicOnPersonas() {
        if (isDevice) {
            androidDriver.context("NATIVE_APP");

            try {
                wait.until(ExpectedConditions.visibilityOf(closeTranslate));
                closeTranslate.click();
            } catch (Exception ignored) {
            }

            androidDriver.context("CHROMIUM");
            wait.until(ExpectedConditions.visibilityOf(btnMenu));
            btnMenu.click();
        }

        btnPersonas.click();
    }

    public void clicOnProductos() {
        btnProductos.click();
    }

    public void clicOnPaquete() {
        wait.until(ExpectedConditions.visibilityOf(btnPaquete));
        btnPaquete.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}

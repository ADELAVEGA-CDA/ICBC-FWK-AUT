package pageBase;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.MobileElement;

import utilsBase.UtilsTest;
import managers.DriverMng;
import globalBase.GlobalParams;

public class BasePage {

    private AppiumDriver<?> driver;
    UtilsTest utils = new UtilsTest();

    public BasePage(){
        this.driver = new DriverMng().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
	
    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }
    
    public void sendKeys(MobileElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }
	
    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, UtilsTest.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    
    public void click(MobileElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }
    
}

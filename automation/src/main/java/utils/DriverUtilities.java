package utils;

import context.TestContext;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class DriverUtilities {
    private WebDriver driver;

    public DriverUtilities() {
        driver = TestContext.getWebDrvMng().getDriver();
    }

    public String getCurrentAndroidActivity() {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        return androidDriver.currentActivity();
    }

    public String getCurrentAndroidContext() {
        AndroidDriver appiumDriver = (AndroidDriver) driver;
        return appiumDriver.getContext();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

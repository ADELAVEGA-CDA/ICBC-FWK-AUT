package stepsDefinition;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AssertSteps {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    private WebDriver driver;
    private int sec = 10;

    public AssertSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void validatePageUrl(String expectedUrl) {
        Assert.assertTrue(getUrl().contains(expectedUrl));
        logger.info(":: The page Url is: " + getUrl());
    }

    public void navigateToBaseUrl(String baseUrl) {
        driver.navigate().to(baseUrl);
    }

    public void validatePageTitle(String expectedTitle) {
        Assert.assertTrue(getTitle().contains(expectedTitle));
        logger.info(":: The title of the site is: " + getTitle());
    }

    public void validatePageSource(String expectedPageSource) {
        Assert.assertTrue(getPageSource().contains(expectedPageSource));
        logger.info(":: The page source is: " + getPageSource());
    }

    public void validateMultipleInPageSource(List<String> table) {
        for (String row : table) {
            Assert.assertTrue(getPageSource().contains(row));
            logger.info("The text " + row + " is in the PageSource");
        }
    }

    public void validateCurrentActivity(String currentActivity) {
        Assert.assertTrue(getCurrentActivity().contains(currentActivity));
        logger.info(":: The current activity in the foreground is: " + currentActivity);
    }

//    public void validateCurrentContext(String currentContext) {
//        Assert.assertTrue(getCurrentContext().contains(currentContext));
//        logger.info(":: The current context is: " + currentContext);
//    }

    private String getCurrentActivity() {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        return androidDriver.currentActivity();
    }

//    private String getCurrentContext() {
//        AppiumDriver appiumDriver = (AppiumDriver) driver;
//        return appiumDriver.getContext();
//    }

    private String getPageSource() {
        return driver.getPageSource();
    }

    private String getUrl() {
        return driver.getCurrentUrl();
    }

    private String getTitle() {
        return driver.getTitle();
    }
}

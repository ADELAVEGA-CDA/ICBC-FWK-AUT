package stepsDefinition;

import context.TestContext;
import driversManager.utils.DriverUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AssertSteps {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    private final WebDriver driver;
    private final int sec = 10;

    private final DriverUtilities driverUtils;

    public AssertSteps() {
        driver = TestContext.getWebDrvMng().getDriver();
        driverUtils = new DriverUtilities();
    }

    public void validatePageUrl(String expectedUrl) {
        Assert.assertTrue(driverUtils.getUrl().contains(expectedUrl));
        logger.info(":: The page Url is: " + driverUtils.getUrl());
    }

    public void navigateToBaseUrl(String baseUrl) {
        driver.navigate().to(baseUrl);
    }

    public void validatePageTitle(String expectedTitle) {
        Assert.assertTrue(driverUtils.getTitle().contains(expectedTitle));
        logger.info(":: The title of the site is: " + driverUtils.getTitle());
    }

    public void validatePageSource(String expectedPageSource) {
        Assert.assertTrue(driverUtils.getPageSource().contains(expectedPageSource));
        logger.info(":: The page source is: " + driverUtils.getPageSource());
    }

    public void validateMultipleInPageSource(List<String> table) {
        for (String row : table) {
            Assert.assertTrue(driverUtils.getPageSource().contains(row));
            logger.info("The text " + row + " is in the PageSource");
        }
    }

    public void validateCurrentActivity(String currentActivity) {
        Assert.assertTrue(driverUtils.getCurrentAndroidActivity().contains(currentActivity));
        logger.info(":: The current activity in the foreground is: " + currentActivity);
    }

    public void validateCurrentContext(String currentContext) {
        Assert.assertTrue(driverUtils.getCurrentAndroidContext().contains(currentContext));
        logger.info(":: The current context is: " + currentContext);
    }
}

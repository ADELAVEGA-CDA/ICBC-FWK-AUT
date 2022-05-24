package pageObjects.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import managers.StartPagesMng;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PageExampleApp extends StartPagesMng {
    @AndroidFindBy(accessibility = "UserName")
    @iOSXCUITFindBy(id = "UserName")
    private WebElement tbxUserName;

    @AndroidFindBy(accessibility = "Password")
    @iOSXCUITFindBy(id = "Password")
    private WebElement tbxPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@name='sign-In']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='sign-In']")
    private WebElement btnLogin;

    @AndroidFindBy(id = "com.flickr.android:id/fragment_welcome_page_title")
    @iOSXCUITFindBy(id = "Welcome")
    private WebElement welcomeMessage;

    private String getPageSource() {
        return androidDriver.getPageSource();
    }

    private String getCurrentActivity() {
        return androidDriver.currentActivity();
    }

    private String getCurrentContext() {
        return androidDriver.getContext();
    }

    public void appFullyLaunched() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
    }

    public void validatePageSource(String expectedPageSource) {
        Assert.assertTrue(getPageSource().contains(expectedPageSource));
        log.info(":: The text " + expectedPageSource + " is present in the app screen's source.");
    }

    public void validateMultipleInPageSource(List<String> table) {
        for (String row : table) {
            Assert.assertTrue(getPageSource().contains(row));
            log.info("The text " + row + " is in the app screen's source.");
        }
    }

    public void validateCurrentActivity(String currentActivity) {
        Assert.assertTrue(getCurrentActivity().contains(currentActivity));
        log.info(":: The current activity in the foreground is: " + currentActivity);
    }

    public void validateCurrentContext(String currentContext) {
        Assert.assertTrue(getCurrentContext().contains(currentContext));
        log.info(":: The current context is: " + currentContext);
    }
}

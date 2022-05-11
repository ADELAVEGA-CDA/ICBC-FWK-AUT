package utils;

import context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtilities {
    private WebDriver driver;
    private WebDriverWait wait;
    private int sec = 10;

    public WebElementUtilities(WebDriver driver) {
        this.driver = driver;
        wait = TestContext.getWebDrvMng().getWait();
    }

    public boolean weElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public boolean weElementIsInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return !element.isDisplayed();
    }

    public boolean weElementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public static String weGetAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

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

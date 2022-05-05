package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtilities {
    private WebDriver driver;
    private int sec = 10;

    public WebElementUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait weWaitForSeconds() {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        return wait;
    }

    public boolean weElementToBeClickable(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public boolean weElementIsInvisible(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.invisibilityOf(element));
        return !element.isDisplayed();
    }

    public boolean weElementIsDisplayed(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public static String weGetAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    private String getPageSource() {return driver.getPageSource(); }

    private String getUrl() {return driver.getCurrentUrl(); }

    private String getTitle() { return driver.getTitle(); }
}

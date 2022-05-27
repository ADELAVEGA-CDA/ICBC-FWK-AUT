package utils;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtilities {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final int sec = 10;

    public WebElementUtilities() {
        driver = TestContext.getWebDrvMng().getDriver();
        wait = TestContext.getWebDrvMng().getWait();
    }

    public boolean elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public boolean elementIsInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return !element.isDisplayed();
    }

    public boolean elementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void wdElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement wdFindElement(By locator) {
        wdElementIsDisplayed(locator);
        return driver.findElement(locator);
    }

    public void wdClick(By locator) {
        wdFindElement(locator).click();
    }

    public void wdSendKeys(By locator, String text, boolean clearFirst) {
        if (clearFirst) wdClick(locator);
        wdFindElement(locator).sendKeys(text);
    }

    public void wdUploadFile(WebElement inputLocator, String fileDir) {
        inputLocator.sendKeys(fileDir);
    }

    public Object wdElementIsDisplayed(By locator) {
        wdHighlight(locator);
        return wait.until(ExpectedConditions.visibilityOf((WebElement) locator));
    }

    public Object wdHighlight(By locator) {
        String wdHighlightedColour = "arguments[0].style.border='5px solid blue";
        WebElement myLocator = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(wdHighlightedColour, myLocator);
    }

    public void wdScrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

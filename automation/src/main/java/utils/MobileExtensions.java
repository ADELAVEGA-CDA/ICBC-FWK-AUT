package utils;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class MobileExtensions extends WebElementUtilities {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private int sec = 10;

    public MobileExtensions(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        wait = TestContext.getWebDrvMng().getWait();
    }

    public void esScrollToPage(WebElement element, int scrollToPage) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        params.put("scrollToPage", scrollToPage);
        driver.executeScript("mobile: scrollToPage", params);
    }

    public void esScrollToPage(WebElement element, String scrollTo, boolean smoothScroll) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        params.put("scrollTo", scrollTo);
        params.put("smoothScroll", smoothScroll);
        driver.executeScript("mobile: scrollToPage", params);
    }

    public void esSetTime(WebElement element, int hours, int minutes) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        params.put("hours", hours);
        params.put("minutes", minutes);
        driver.executeScript("mobile: setTime", params);
    }

    public void esSetDate(WebElement element, int year, int monthOfYear, int dayOfMonth) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        params.put("year", year);
        params.put("monthOfYear", monthOfYear);
        params.put("dayOfMonth", dayOfMonth);
        driver.executeScript("mobile: setDate", params);
    }

    public void esCloseDrawer(WebElement element, int gravity) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        params.put("gravity", gravity);
        driver.executeScript("mobile: closeDrawer", params);
    }

    public void esCloseDrawer(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        driver.executeScript("mobile: closeDrawer", params);
    }

    public void esOpenDrawer(WebElement element, int gravity) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        params.put("gravity", gravity);
        driver.executeScript("mobile: openDrawer", params);
    }

    public void esOpenDrawer(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);
        driver.executeScript("mobile: openDrawer", params);
    }

    public void esIsToastVisible(String text, boolean isRegEx) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", text);
        params.put("isRegexp", isRegEx);
        driver.executeScript("mobile: isToastVisible", params);
    }

    public void esSwipe(String direction, WebElement element) {
        meElementIsDisplayed(element);
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);
    }

    public void esSwipe(String direction) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        driver.executeScript("mobile: swipe", params);
    }

    public void xcScroll(String direction, WebElement element) {
        meElementIsDisplayed(element);
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", element);
        driver.executeScript("mobile:scroll", params);
    }

    public void xcScroll(String direction, String parameter, String nameOrPredicateString) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put(parameter, nameOrPredicateString);
        driver.executeScript("mobile:scroll", params);
    }

    public void xcPinchOrZoom(double scale) {
        Map<String, Object> args = new HashMap<>();
        args.put("scale", scale);
        driver.executeScript("mobile: pinch", args);
    }

    public void xcPinchOrZoom(WebElement element, double scale) {
        meElementIsDisplayed(element);
        Map<String, Object> args = new HashMap<>();
        args.put("scale", scale);
        args.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: pinch", args);
    }

    public void xcTapOn(double x, double y) {
        Map<String, Object> args = new HashMap<>();
        args.put("x", x);
        args.put("y", y);
        driver.executeScript("mobile: tap", args);
    }

    public void xcTapOn(WebElement element, double x, double y) {
        meElementIsDisplayed(element);
        Map<String, Object> args = new HashMap<>();
        args.put("element", ((RemoteWebElement) element).getId());
        args.put("x", x);
        args.put("y", y);
        driver.executeScript("mobile: tap", args);
    }

    public void xcDoubleTapOn(double x, double y) {
        Map<String, Object> args = new HashMap<>();
        args.put("x", x);
        args.put("y", y);
        driver.executeScript("mobile: doubleTap", args);
    }

    public void xcDoubleTapOn(WebElement element) {
        meElementIsDisplayed(element);
        Map<String, Object> args = new HashMap<>();
        args.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: doubleTap", args);
    }

    public void xcTwoFingerTapOn(WebElement element) {
        meElementIsDisplayed(element);
        Map<String, Object> args = new HashMap<>();
        args.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: twoFingerTap", args);
    }

    public void xcTouchAndHoldOn(WebElement element, double duration) {
        meElementIsDisplayed(element);
        Map<String, Object> args = new HashMap<>();
        args.put("element", ((RemoteWebElement) element).getId());
        args.put("duration", duration);
        driver.executeScript("mobile: touchAndHold", args);
    }

    public void xcDragFromToForDuration(double duration, double fromX, double fromY, double toX, double toY) {
        Map<String, Object> args = new HashMap<>();
        args.put("duration", duration);
        args.put("fromX", fromX);
        args.put("fromY", fromY);
        args.put("toX", toX);
        args.put("toY", toY);
        driver.executeScript("mobile: dragFromToForDuration", args);
    }

    public void xcDragFromToForDuration(WebElement element, double duration, double fromX, double fromY, double toX, double toY) {
        meElementIsDisplayed(element);
        Map<String, Object> args = new HashMap<>();
        args.put("element", ((RemoteWebElement) element).getId());
        args.put("duration", duration);
        args.put("fromX", fromX);
        args.put("fromY", fromY);
        args.put("toX", toX);
        args.put("toY", toY);
        driver.executeScript("mobile: dragFromToForDuration", args);
    }

    public void xcSelectPickerWheelValue(WebElement element, String order, double offset) {
        Map<String, Object> params = new HashMap<>();
        params.put("order", order);
        params.put("offset", offset);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }

    public void xcPerformActionOnAlert(String action, String buttonLabel) {
        wait.until(ExpectedConditions.alertIsPresent());
        HashMap<String, String> args = new HashMap<>();
        args.put("action", action);
        args.put("buttonLabel", buttonLabel);
        driver.executeScript("mobile: alert", args);
    }

    public void xcPerformActionOnAlert(String action) {
        wait.until(ExpectedConditions.alertIsPresent());
        HashMap<String, String> args = new HashMap<>();
        args.put("action", action);
        driver.executeScript("mobile: alert", args);
    }

    public boolean meElementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}

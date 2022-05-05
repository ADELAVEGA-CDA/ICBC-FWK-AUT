package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class MobileUtilities {
    private AppiumDriver driver;
    private int sec = 10;
    private static TouchAction touchAction;

    public MobileUtilities(AppiumDriver driver) {
        this.driver = driver;
        touchAction = new TouchAction(driver);
    }

    public WebDriverWait meWaitForSeconds() {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        return wait;
    }

    public boolean meElementToBeClickable(WebElement element) {
        meWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public void meTap(MobileElement mobileElement) {
        meElementToBeClickable(mobileElement);
        touchAction.tap(tapOptions().withElement(element(mobileElement))).perform();
    }

    public void meSwipeFromElementToElement(MobileElement fromMobileElement, MobileElement toMobileElement) {
        meElementToBeClickable(fromMobileElement);
        meElementToBeClickable(toMobileElement);
        touchAction.longPress(longPressOptions().withElement(element(fromMobileElement))
                .withDuration(ofSeconds(2))).moveTo(element(toMobileElement)).release().perform();
    }

    public void meLongPress(MobileElement mobileElement) {
        meElementToBeClickable(mobileElement);
        touchAction.longPress(longPressOptions().withElement(element(mobileElement))
                .withDuration(ofSeconds(2))).release().perform();
    }

    public void meSwipe(Enums.DIRECTION direction, long duration) {
        Dimension size = driver.manage().window().getSize();
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case RIGHT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();
                break;

            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();
                break;

            case UP:
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();
                break;

            case DOWN:
                startY = (int) (size.height * 0.70);
                endY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;
        }
    }

    private String getCurrentActivity() {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        return androidDriver.currentActivity();
    }

    private String getCurrentContext() { return driver.getContext(); }
}

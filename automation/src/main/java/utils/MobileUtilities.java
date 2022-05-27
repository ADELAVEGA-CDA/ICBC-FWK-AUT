package utils;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class MobileUtilities {
    private final AppiumDriver driver;
    private final int sec = 10;
    private final WebDriverWait wait;
    private static TouchAction touchAction;

    public MobileUtilities() {
        driver = (AppiumDriver) TestContext.getWebDrvMng().getDriver();
        wait = TestContext.getWebDrvMng().getWait();
        touchAction = new TouchAction((PerformsTouchActions) driver);
    }

    public boolean meElementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean meElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public void meTap(WebElement mobileElement) {
        meElementToBeClickable(mobileElement);
        touchAction.tap(tapOptions().withElement(element(mobileElement))).perform();
    }

    public void meLongPress(WebElement mobileElement) {
        meElementToBeClickable(mobileElement);
        touchAction.longPress(longPressOptions().withElement(element(mobileElement))
                .withDuration(ofSeconds(2))).release().perform();
    }

    public void meSwipeFromElementToElement(WebElement fromMobileElement, WebElement toMobileElement) {
        meElementToBeClickable(fromMobileElement);
        meElementToBeClickable(toMobileElement);
        touchAction.longPress(longPressOptions().withElement(element(fromMobileElement))
                .withDuration(ofSeconds(2))).moveTo(element(toMobileElement)).release().perform();
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

            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);

            case UP:
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                startX = (size.width / 2);

            case DOWN:
                startY = (int) (size.height * 0.70);
                endY = (int) (size.height * 0.30);
                startX = (size.width / 2);
        }

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

    public void meSendKeys(WebElement element, String text, boolean clearFirst) {
        meElementIsDisplayed(element);
        if (clearFirst) meTap(element);
        element.sendKeys(text);
    }

    public void mePressKeys(AndroidKey androidKey) {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.pressKey(new KeyEvent(androidKey));
    }

    public void mePressKeysWithFlags(AndroidKey androidKey) {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.pressKey(new KeyEvent(androidKey)
                .withFlag(KeyEventFlag.SOFT_KEYBOARD)
                .withFlag(KeyEventFlag.KEEP_TOUCH_MODE)
                .withFlag(KeyEventFlag.EDITOR_ACTION));
    }

    public void meLongPressKeys(AndroidKey androidKey) {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.longPressKey(new KeyEvent(androidKey));
    }

    public void meLongPressKeysWithFlags(AndroidKey androidKey) {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.longPressKey(new KeyEvent(androidKey)
                .withFlag(KeyEventFlag.SOFT_KEYBOARD)
                .withFlag(KeyEventFlag.KEEP_TOUCH_MODE)
                .withFlag(KeyEventFlag.EDITOR_ACTION));
    }
}

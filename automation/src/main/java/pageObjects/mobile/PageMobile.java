package pageObjects.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import managers.StartPagesMng;
import org.openqa.selenium.WebElement;

public class PageMobile extends StartPagesMng {
    @AndroidFindBy(accessibility = "UserName")
    @iOSXCUITFindBy(id = "UserName")
    private WebElement tbxUserName;

    @AndroidFindBy(accessibility = "Password")
    @iOSXCUITFindBy(id = "Password")
    private WebElement tbxPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@name='sign-In']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='sign-In']")
    private WebElement btnLogin;

    public PageMobile enterUserName(String username) {
        tbxUserName.clear();
        tbxUserName.sendKeys(username);
        return this;
    }

    public PageMobile enterPassword(String password) {
        tbxPassword.sendKeys(password);
        return this;
    }

    public PageMobile pressLoginBtn() {
        btnLogin.click();
        return this;
    }

}
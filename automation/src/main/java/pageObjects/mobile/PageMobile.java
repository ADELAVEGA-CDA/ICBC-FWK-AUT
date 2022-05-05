package pageObjects.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import managers.StartPagesMobileMng;

public class PageMobile extends StartPagesMobileMng {
    @AndroidFindBy(accessibility = "UserName")
    @iOSXCUITFindBy(id = "UserName")
    private MobileElement tbxUserName;

    @AndroidFindBy(accessibility = "Password")
    @iOSXCUITFindBy(id = "Password")
    private MobileElement tbxPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@name='sign-In']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='sign-In']")
    private MobileElement btnLogin;

    public PageMobile(AppiumDriver driver) {
        super(driver);
    }

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

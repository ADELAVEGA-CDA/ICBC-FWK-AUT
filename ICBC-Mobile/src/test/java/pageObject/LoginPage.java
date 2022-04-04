package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import utilsBase.UtilsTest;
import pageBase.BasePage;
import pageBase.LocatorsPage;

public class LoginPage extends LocatorsPage {

	
	UtilsTest utils = new UtilsTest();
	BasePage basePage = new BasePage();
	
	@AndroidFindBy (accessibility = LocatorsPage.AndroidUserName) 
	@iOSXCUITFindBy (id = LocatorsPage.iOSUserName)
	private MobileElement tbxUserName;
	
	@AndroidFindBy (accessibility = LocatorsPage.AndroidPassword) 
	@iOSXCUITFindBy (id = LocatorsPage.iOSPassword)
	private MobileElement tbxPassword;
	
	@AndroidFindBy (xpath = LocatorsPage.AndroidSignIn) 
	@iOSXCUITFindBy (xpath = LocatorsPage.AndroidSignIn)
	private MobileElement btnLogin;
	
	public LoginPage enterUserName(String username) {
		basePage.clear(tbxUserName);
		basePage.sendKeys(tbxUserName, username, " Login with user " + username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		basePage.sendKeys(tbxPassword, password, " Password is " + password);
		return this;
	}
	
	public LoginPage pressLoginBtn() {
		basePage.click(btnLogin, " Click on Sign-In button");
		return this;
	}
	
}

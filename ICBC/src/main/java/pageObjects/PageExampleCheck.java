package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageExampleCheck {

	public PageExampleCheck(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	// FIND BY HOW AND USING
	@FindBy(how=How.CSS,using=".cssValue")
	private WebElement tbxName_check; 
	@FindBy(how=How.XPATH,using="//*[@ID='idValue']")
	private WebElement btnName_check; 
	// USE DEFINED ELEMENT
	public void enterName(String name) {
		tbxName_check.sendKeys(name);}
	public void clickName() {
		btnName_check.click();}
	
}

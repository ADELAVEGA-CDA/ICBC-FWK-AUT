package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderMng;

public class PageExampleHome {

	WebDriver drv;
	public PageExampleHome(WebDriver driver) {
		drv=driver;
		PageFactory.initElements(driver,this);}
	
	private Boolean _size=FileReaderMng.getInstance().getConfigReader().getBrowserSize();
	private String _url=FileReaderMng.getInstance().getConfigReader().getURL();
	public void toHomepage() {
		if(_size)drv.manage().window().maximize();
		System.out.println("__ToNavigate_"+_url+"__");
		drv.get(_url);}

	// FIND BY HOW AND USING
	@FindBy(how=How.CSS,using=".noo-search")
	private WebElement btnSearch; 
	@FindBy(how=How.CSS,using=".form-control")
	private WebElement tbxSearch; 
	@FindBy(how=How.CSS,using=".noo-product-inner")
	private List<WebElement> listCard;
	
	// USE DEFINED ELEMENT
	public void clickOn_Search() {
		btnSearch.click();}
	public void type_SearchText(String search) {
		tbxSearch.sendKeys(search);}
	public void enterOn_SearchText() {
		tbxSearch.sendKeys(Keys.ENTER);}
	public int size_listCard() {
		return listCard.size();}
	
}

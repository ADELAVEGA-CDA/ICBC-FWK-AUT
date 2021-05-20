package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderMng;

public class Page_sample_Home {

	WebDriver drv;
	public Page_sample_Home(WebDriver driver) {
		drv=driver;
		PageFactory.initElements(driver,this);}
	
	private Boolean _size=FileReaderMng.getInstance().getConfigReader().getBrowserSize();
	private String _url=FileReaderMng.getInstance().getConfigReader().getURL();
	public void to_HomeICBC() {
		if(_size)drv.manage().window().maximize();
		System.out.println("__ToNavigate_"+_url+"__");
		drv.get(_url);}

	// FIND BY HOW AND USING
	@FindBy(how=How.CSS,using=".po-hea__menu-title")
	private WebElement btnPersonas; 
	@FindBy(how=How.XPATH,using="//*[contains(@class,'po-hea__submenu-item')][2]")
	private WebElement btnProductos; 
	@FindBy(how=How.XPATH,using="//ul[contains(@class,'po-hea__subsubmenu-list')]/li[2]")
	private WebElement btnPaquete; 

	
	// USE DEFINED ELEMENT
	public void clic_onPersonas() {
		btnPersonas.click();}
	public void clic_onProductos() {
		btnProductos.click();}
	public void clic_onPaquete() {
		btnPaquete.click();}
	public String get_Url() {
		return drv.getCurrentUrl();}
	public String get_Title() {
		return drv.getTitle();}
	
}

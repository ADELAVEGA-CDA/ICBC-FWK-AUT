package managers;

import org.openqa.selenium.WebDriver;

import base.GlobalParams;
import base.GlobalRest;
import pageObjects.PageExampleE2E;
import pageObjects.PageExampleHome;
import pageObjects.PageExampleCheck;

public class StartPagesMng {

	private WebDriver driver;
	public StartPagesMng(WebDriver driver) {
		this.driver=driver;}
	
	// Initialization page
	private PageExampleE2E end2end;
	private PageExampleHome home;
	private PageExampleCheck check;
	public PageExampleE2E getEnd2End() {
		return(end2end==null)?end2end=new PageExampleE2E(driver):end2end;}
	public PageExampleHome getHome() {
		return(home==null)?home=new PageExampleHome(driver):home;}
	public PageExampleCheck getCheck() {
		return(check==null)?check=new PageExampleCheck(driver):check;}
	
	// Initialization base
	private GlobalParams params;
	private GlobalRest rest;
	public GlobalParams getGlobalParams() {
		return(params==null)?params=new GlobalParams():params;}
	public GlobalRest getGlobalRest() {
		return(rest==null)?rest=new GlobalRest():rest;}

}

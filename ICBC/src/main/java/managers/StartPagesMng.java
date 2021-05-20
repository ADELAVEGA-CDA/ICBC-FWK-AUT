package managers;

import org.openqa.selenium.WebDriver;

import base.GlobalParams;
import base.GlobalRest;
import pageObjects.PageExampleE2E;
import pageObjects.Page_sample_Home;
import pageObjects.Page_sample_Pquetes;

public class StartPagesMng {

	private WebDriver driver;
	public StartPagesMng(WebDriver driver) {
		this.driver=driver;}
	
	// Initialization page
	private PageExampleE2E end2end;
	private Page_sample_Home home;
	private Page_sample_Pquetes check;
	public PageExampleE2E getEnd2End() {
		return(end2end==null)?end2end=new PageExampleE2E(driver):end2end;}
	public Page_sample_Home getHome() {
		return(home==null)?home=new Page_sample_Home(driver):home;}
	public Page_sample_Pquetes getCheck() {
		return(check==null)?check=new Page_sample_Pquetes(driver):check;}
	
	// Initialization base
	private GlobalParams params;
	private GlobalRest rest;
	public GlobalParams getGlobalParams() {
		return(params==null)?params=new GlobalParams():params;}
	public GlobalRest getGlobalRest() {
		return(rest==null)?rest=new GlobalRest():rest;}

}

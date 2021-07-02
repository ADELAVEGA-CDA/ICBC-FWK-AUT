package managers;

import org.openqa.selenium.WebDriver;

import base.GlobalParams;
import base.GlobalRest;
import pageObjects.PageExampleE2E;
import pageObjects.Page_sample_Scenario;
import pageObjects.Page_sample_ScenarioOutline;

public class StartPagesMng {

	private WebDriver driver;
	public StartPagesMng(WebDriver driver) {
		this.driver=driver;}
	
	// Initialization page
	private PageExampleE2E end2end;
	private Page_sample_Scenario home;
	private Page_sample_ScenarioOutline check;
	public PageExampleE2E getEnd2End() {
		return(end2end==null)?end2end=new PageExampleE2E(driver):end2end;}
	public Page_sample_Scenario getHome() {
		return(home==null)?home=new Page_sample_Scenario(driver):home;}
	public Page_sample_ScenarioOutline getPersonas() {
		return(check==null)?check=new Page_sample_ScenarioOutline(driver):check;}
	
	// Initialization base
	private GlobalParams params;
	private GlobalRest rest;
	public GlobalParams getGlobalParams() {
		return(params==null)?params=new GlobalParams():params;}
	public GlobalRest getGlobalRest() {
		return(rest==null)?rest=new GlobalRest():rest;}

}

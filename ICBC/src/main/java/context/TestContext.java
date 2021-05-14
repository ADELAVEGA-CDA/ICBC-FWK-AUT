package context;

import managers.StartPagesMng;
import managers.BrowsersMng;

public class TestContext {

	private BrowsersMng webDrvMng;
	private StartPagesMng pageObjMng;
	private ScenContext scenContext;
	
	public TestContext() {
		webDrvMng=new BrowsersMng();
		pageObjMng=new StartPagesMng(webDrvMng.getDrv());
		scenContext=new ScenContext();}
	
	public BrowsersMng getWebDrvMng() {
		return webDrvMng;}
	public StartPagesMng getPageObjMng() {
		return pageObjMng;}
	public ScenContext getScenarioContext() {
		return scenContext;}
	
}

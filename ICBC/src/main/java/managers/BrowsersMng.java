package managers;

import enums.DriversType;
import enums.Environment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowsersMng {

	private WebDriver driver;
	private static DriversType brwType;
	private static Environment ambType;
	private static String webDrv;
	private static String webDrvPath;
	private static boolean brwSize;
	private static long waitTime;
	
	public BrowsersMng() {
		brwType=FileReaderMng.getInstance().getConfigReader().getBrowser();
		ambType=FileReaderMng.getInstance().getConfigReader().getAmbiente();
		webDrv=FileReaderMng.getInstance().getConfigReader().getWebDriver();
		webDrvPath=FileReaderMng.getInstance().getConfigReader().getDriverPath();
		brwSize=FileReaderMng.getInstance().getConfigReader().getBrowserSize();
		waitTime=FileReaderMng.getInstance().getConfigReader().getWaitTime();
	}
	
	public WebDriver getDrv() {
		if(driver==null) {
		if(ambType==Environment.LOCAL){driver=initDrv();System.out.println("__getDrv__local_environment__");}
		else if(ambType==Environment.LOCAL_API)System.out.println("__getDrv__api_environment__local_api__");
		else if(ambType==Environment.LOCAL_HEADLESS){driver=initDrv();System.out.println("__getDrv__local_headless_environment__");}
		else if(ambType==Environment.REMOTO){driver=initDrv();System.out.println("__getDrv__remote_environment__");}
		else if(ambType==Environment.REMOTO_API)System.out.println("__getDrv__api_environment__remoto_api__");
		else if(ambType==Environment.REMOTO_HEADLESS){System.out.println("__getDrv__remote_headless_environment__");}
		else throw new RuntimeException("__error_getDrv_Verify__");}
		return driver;
	}
	
	// INIT DRIVERS
	private WebDriver initDrv() {
		switch(ambType) {
			case LOCAL:driver=createLocal();System.out.println("__initDrv__create_local_drv__");
				break;
			case LOCAL_API:System.out.println("__create_Drv__local_api__");
				break;
			case LOCAL_HEADLESS:createLocalHeadless();System.out.println("__create_Drv__local_headless__");
				break;
			case REMOTO:driver=createRemoto();System.out.println("__initDrv__create_remote_drv__");
				break;
			case REMOTO_API:System.out.println("__create_Drv__remoto_api__");
				break;
			case REMOTO_HEADLESS:System.out.println("__create_Drv__remoto_headless__");
				break;
			default:System.out.println("__verify__ambType_case__");}
		return driver;
	}
	
	private WebDriver createRemoto() { 
		throw new RuntimeException("__verify__createRemoto_WebDriver__");
	}
	
	private WebDriver createLocal() {
		switch(brwType) {
			case FIREFOX:System.setProperty(webDrv,webDrvPath);
				driver=new FirefoxDriver();System.out.println("__driver_new_FirefoxFriver__");
				break;
			case INTERNETEXPLORER:System.setProperty(webDrv,webDrvPath);
				driver=new InternetExplorerDriver();System.out.println("__driver_new_InternetExplorerDriver__");
				break;
			case CHROME:System.setProperty(webDrv,webDrvPath);
				driver=new ChromeDriver();System.out.println("__driver_new_ChromeDriver__");
				break;
			default:System.out.println("__verify__brwType_case__");}
		if(brwSize)driver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
		return driver;
	}
	
	private WebDriver createLocalHeadless() {
		switch(brwType) {
			case CHROME:System.setProperty(webDrv,webDrvPath);
				ChromeOptions chromeOptions=new ChromeOptions();
				chromeOptions.addArguments("headless");
				chromeOptions.addArguments("disable-gpu");
				chromeOptions.addArguments("window-size=1280,800");
				chromeOptions.addArguments("ignore-certificate-errors");
				driver=new ChromeDriver(chromeOptions);System.out.println("__driver_new_ChromeDriver_Headless__");
				break;
			default:System.out.println("__verify__brwType_Headless_case__");}
		return driver;
	}
	
	public void closeBrw() {
		if(ambType==Environment.LOCAL_API||ambType==Environment.REMOTO_API)System.out.println("__closeBrw__without_browser__");
		else {driver.close();driver.quit();}
	}
	
}

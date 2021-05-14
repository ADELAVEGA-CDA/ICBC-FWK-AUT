package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.Environment;
import enums.DriversType;

public class ConfigReader {
	
	private Properties property;
	private final String pathFile="configs\\config.properties";
	private String message="__Error_with_the_file_or_the_value__Verify__>>_";
	
	public ConfigReader() {
		BufferedReader lector;
		try {
			lector=new BufferedReader(new FileReader(pathFile));
			property=new Properties();
			try {
				property.load(lector);
				lector.close();
			} catch(IOException e) {
				e.printStackTrace();}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(message+"_ConfigReader_method__");}}
	
	public String getDriverPath() {
		String rutaCHR=property.getProperty("driverPath");
		if(rutaCHR!=null) return rutaCHR;
		else throw new RuntimeException(message+"_Path_to_the_file__");}
	
	public String getWebDriver() {
		String driverCHR=property.getProperty("webdriver");
		if(driverCHR!=null) return driverCHR;
		else throw new RuntimeException(message+"_WebDriver__");}
	
	public long getWaitTime() {
		String time=property.getProperty("waitTime");
		if(time!=null) return Long.parseLong(time);
		else throw new RuntimeException(message+"__time_wait_value__");}
	
	public String getURL() {
		String url=property.getProperty("URL");
		if(url!=null) return url;
		else throw new RuntimeException(message+"_URL__");}
	
	public Boolean getBrowserSize() {
		String tamaño=property.getProperty("maxWin");
		if(tamaño!=null) return Boolean.valueOf(tamaño);
		return true;}
	
	public Environment getAmbiente() {
		String scope=property.getProperty("environment");System.out.println(">>SCOPE>>"+scope);
		if(scope.equalsIgnoreCase("local")) return Environment.LOCAL;
		else if(scope.equalsIgnoreCase("remote")) return Environment.REMOTO;
		else if(scope.equalsIgnoreCase("local_api"))return Environment.LOCAL_API;
		else if(scope.equalsIgnoreCase("remoto_api"))return Environment.REMOTO_API;
		else if(scope.equalsIgnoreCase("local_headless"))return Environment.LOCAL_HEADLESS;
		else if(scope.equalsIgnoreCase("remoto_headless"))return Environment.REMOTO_HEADLESS;
		else throw new RuntimeException(message+"_error_wiht_the_environment__");}
	
	public DriversType getBrowser() {
		String driverType=property.getProperty("browser");
		if(driverType.equalsIgnoreCase("chrome")) return DriversType.CHROME;
		else if(driverType.equalsIgnoreCase("firefox")) return DriversType.FIREFOX;
		else if(driverType.equalsIgnoreCase("explorer")) return DriversType.INTERNETEXPLORER;
		else throw new RuntimeException(message+"_error_with_the_driver_type__");}
	
	public String getConfigReporte() {
		String report=property.getProperty("reportConfigPath");
		if(report!=null)return report;
		else throw new RuntimeException(message+"_error_with_the-ConfigReporte_path__");}
	
	public String getTestDataPath() {
		String testDataPath=property.getProperty("testDataPath");
		if(testDataPath!=null)return testDataPath;
		else throw new RuntimeException(message+"_error_testDataPath_not_specified__");}
	
	public String getReportPath() {
		String reportPath=property.getProperty("reportPath");
		if(reportPath!=null)return reportPath;
		else throw new RuntimeException(message+"_error_reportPath_not_specified__");}
	
	public String getSceenshotPath() {
		String screenshotPath=property.getProperty("reportScreenshotPath");
		if(screenshotPath!=null)return screenshotPath;
		else throw new RuntimeException(message+"_error_reportScreenshotPath_not_specified__");}
	
}

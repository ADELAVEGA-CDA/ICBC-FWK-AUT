package stepsDefinition;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import enums.Environment;
import managers.FileReaderMng;

public class Hooks {

	TestContext tstContext;
	private static Environment ambType;
	private static String screenshotPath;
	public Hooks(TestContext context) {
		tstContext=context;
		ambType=FileReaderMng.getInstance().getConfigReader().getAmbiente();
		screenshotPath=FileReaderMng.getInstance().getConfigReader().getSceenshotPath();
	}
	
	@Before
	public void beforeSteps(Scenario scenario) {
		if(scenario.getName().equals("Scenario Name")) {
			Reporter.assignAuthor("Automation Teams");}}
	
	@After(order=0)
	public void afterSteps() throws InterruptedException {
		Thread.sleep(5000);
		tstContext.getWebDrvMng().closeBrw();}
	
	@After(order=1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenShot=scenario.getName().replaceAll(" ","_");System.out.println(screenShot);
			Date date=new Date();
			DateFormat formatDate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String dateNow=formatDate.format(date);
			String file=dateNow.replace("/","").replace(":","").replace(" ","_")+"_";
			try {System.out.println(screenShot+" | "+screenshotPath);
				File sourcePath=((TakesScreenshot)tstContext.getWebDrvMng().getDrv()).getScreenshotAs(OutputType.FILE);
				File destinationPath=new File(System.getProperty("user.dir")+"/target/reportesCucumber/reporteExtent/ScreenShot/"+file+screenShot+".png");
				Files.copy(sourcePath,destinationPath);   
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
				System.out.println(e);}}}
}

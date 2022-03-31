package runnersClass;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderMng;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/",
		glue={"stepsDefinition"},
		tags={"@CompraIndice"},
		plugin={"pretty","com.cucumber.listener.ExtentCucumberFormatter:",
				"json:target/reportesCucumber/reporteJSON/rptJSON.json",
		}
	)

public class RunnerTest {

	private static String reportPath=FileReaderMng.getInstance().getConfigReader().getReportPath();
	@BeforeClass
    public static void setup() {
    	Date date=new Date();
		DateFormat formatDate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String currentDate = formatDate.format(date);
		String fileName="reporte_"+(((currentDate.replace("/","")).replace(":","")).replace(" ","_"));
        ExtentProperties extentProperties=ExtentProperties.INSTANCE;
        extentProperties.setReportPath(reportPath+fileName+".html");
    }
	
	@AfterClass
	public static void writeExtentReport() {
			Reporter.loadXMLConfig(new File(FileReaderMng.getInstance().getConfigReader().getConfigReporte()));
			Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
			Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
			Reporter.setSystemInfo("Machine", "Windows 10"+"64 Bit");
			Reporter.setSystemInfo("Selenium", "3.7.0");
			Reporter.setSystemInfo("Maven", "3.5.2");
			Reporter.setSystemInfo("Java Version", "1.8.0");
	}
	
}

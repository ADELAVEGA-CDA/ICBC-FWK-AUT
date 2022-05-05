package stepsDefinition;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import enums.Environment;
import managers.FileReaderMng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    TestContext tstContext;
    private static Environment ambType;
    private static String screenshotPath;
    private static String reportPath = FileReaderMng.getInstance().getConfigReader().getReportPath();

    public Hooks(TestContext context) {
        tstContext = context;
        ambType = FileReaderMng.getInstance().getConfigReader().getAmbiente();
        screenshotPath = FileReaderMng.getInstance().getConfigReader().getSceenshotPath();
    }

    @Before
    public void beforeSteps(Scenario scenario) {
        if (scenario.getName().equals("Scenario Name")) {
            Reporter.assignAuthor("Automation Teams");
        }
    }

    @After(order = 0)
    public void afterSteps() throws InterruptedException {
        Thread.sleep(5000);
        tstContext.getWebDrvMng().closeBrw();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenShot = scenario.getName().replaceAll(" ", "_");
            Date date = new Date();
            DateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String dateNow = formatDate.format(date);
            String file = dateNow.replace("/", "").replace(":", "").replace(" ", "_") + "_";
            try {
                File sourcePath = ((TakesScreenshot) tstContext.getWebDrvMng().getDrv()).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/reportesCucumber/" +
                        "reporteExtent/ScreenShot/" + file + screenShot + ".png");
                Files.copy(sourcePath, destinationPath);
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
                logger.warn(e);
            }
        }
    }

    @BeforeClass
    public static void setup() {
        Date date = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String currentDate = formatDate.format(date);
        String fileName = "reporte_" + (((currentDate.replace("/", "")).replace(":", ""))
                .replace(" ", "_"));
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(reportPath + fileName + ".html");
    }

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderMng.getInstance().getConfigReader().getConfigReporte()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0");
    }
}

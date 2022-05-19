package stepsDefinition;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.FileReaderMng;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DateUtilities;
import utils.FileUtilities;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(String.valueOf(FileUtilities.class));
    TestContext testContext;

    @Before
    public void beforeSteps() {
        testContext = new TestContext();
        TestContext.getWebDrvMng().setDriver();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName().replaceAll(" ", "_") + "_";

            DateUtilities dateUtils = new DateUtilities();
            String dateName = dateUtils.getDateString();

            String screenshotPath = FileReaderMng.getInstance().getConfigReader().getSceenshotPath();

            File midPath = new File(System.getProperty("user.dir") + screenshotPath);
            if (!midPath.exists())
                midPath.mkdirs();

            TakesScreenshot screenshot = (TakesScreenshot) TestContext.getWebDrvMng().getDriver();
            byte[] srcByte = screenshot.getScreenshotAs(OutputType.BYTES);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(midPath + "/" + scenarioName + dateName + ".png");
            FileUtils.copyFile(srcFile, destFile);
            scenario.attach(srcByte, "image/png", "image");

            logger.info("ScreenCapture in: " + destFile);

            //TODO ANDROID DEVICE CAPTURE
            //TODO IOS DEVICE CAPTURE
        }
    }

    @After(order = 0)
    public void afterSteps() throws InterruptedException {
        Thread.sleep(5000);
        TestContext.getWebDrvMng().closeBrowser();
    }
}

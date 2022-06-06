package stepsDefinition;

import context.TestContext;
import driversManager.utils.DateUtilities;
import enums.DriversType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.FileReaderMng;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {
    protected Logger log = LogManager.getLogger(String.valueOf(this.getClass()));
    TestContext testContext;

    @Before
    public void beforeSteps(Scenario scenario) {
        testContext = new TestContext();

        String tag = scenario.getSourceTagNames().iterator().next();
        String tagFormatted = tag.toUpperCase().substring(1);

        if (EnumUtils.isValidEnum(DriversType.class, tagFormatted)) {
            DriversType tagType = DriversType.valueOf(tagFormatted);
            TestContext.getWebDrvMng().setDriver(tagType);
        } else {
            DriversType brwType = FileReaderMng.getInstance().getConfigReader().getBrowser();
            TestContext.getWebDrvMng().setDriver(brwType);
        }
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
            scenario.attach(srcByte, "image/png", scenario.getName());

            log.info("ScreenCapture in: " + destFile);
        }
    }

    @After(order = 0)
    public void afterSteps() throws InterruptedException {
        Thread.sleep(5000);
        TestContext.getWebDrvMng().closeBrowser();
    }
}

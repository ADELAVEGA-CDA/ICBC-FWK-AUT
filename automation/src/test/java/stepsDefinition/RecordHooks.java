package stepsDefinition;

import context.TestContext;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import managers.FileReaderMng;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import recorder.CustomScreenRecorder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RecordHooks {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));
    private final boolean screenRecord = FileReaderMng.getInstance().getConfigReader().getRecordWindows();

    private CustomScreenRecorder screenRecorder;
    private String destinationPath;
    private String videoName;
    private WebDriver driver;
    private boolean isDeviceApp;

    @Before
    public void before(Scenario scenario) {
        if (screenRecord) {
            try {
                destinationPath = System.getProperty("user.dir") + "/target/screen-records";
                videoName = scenario.getClass().getSimpleName() + "-" + scenario.getName();
                isDeviceApp = TestContext.getWebDrvMng().isDeviceApp();

                if (isDeviceApp) {
                    driver = TestContext.getWebDrvMng().getDriver();

                    ((CanRecordScreen) driver).startRecordingScreen();
                } else {
                    screenRecorder = new CustomScreenRecorder(new File(destinationPath));
                    screenRecorder.startRecording(videoName, true);
                }
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
        }
    }

    @After
    public void after(Scenario scenario) {
        if (screenRecord) {
            logger.info("Test FAILED " + scenario.getClass().getName() + " - " + scenario.getName());
            stopScreenRecording(scenario.isFailed());
        }
    }

    private void stopScreenRecording(boolean keepFile) {
        try {
            if (isDeviceApp) {
                String base64String = ((CanRecordScreen) driver).stopRecordingScreen();
                byte[] data = Base64.decodeBase64(base64String);
                Path path = Paths.get(destinationPath + videoName);
                Files.write(path, data);
            } else {
                screenRecorder.stopRecording(keepFile);
            }

            attachVideo(destinationPath);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    @Attachment(value = "video", type = "video/mp4")
    public void attachVideo(String path) throws Exception {
        getFile(path);
    }

    public void getFile(String fileName) throws Exception {
        File file = new File(fileName);
        Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }
}

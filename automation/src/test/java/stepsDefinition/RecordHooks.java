package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.FileReaderMng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import recorder.CustomScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RecordHooks {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));
    private boolean screenRecord = FileReaderMng.getInstance().getConfigReader().getRecordWindows();

    private CustomScreenRecorder screenRecorder;

    @Before
    public void before(Scenario scenario) {
        if (screenRecord) {
            try {
                //this is the location that we are going to save the recorded file
                screenRecorder = new CustomScreenRecorder(new File(System.getProperty("user.dir") + "/target/screen-records"));
                screenRecorder.startRecording(scenario.getClass().getSimpleName() + "-" + scenario.getName(), true);
            } catch (IOException | AWTException e) {
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
            screenRecorder.stopRecording(keepFile);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }
}

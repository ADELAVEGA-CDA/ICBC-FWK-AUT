package driversManager;

import dataProviders.ConfigReader;
import driversManager.utils.DateUtilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import managers.FileReaderMng;

import java.io.File;

public class AppiumServer {
    public static AppiumDriverLocalService appiumServer;

    public static void start() {
        ConfigReader config = FileReaderMng.getInstance().getConfigReader();
        DateUtilities dateUtils = new DateUtilities();
        String dateName = dateUtils.getUniqueString();
        String logFile = System.getProperty("user.dir") + "/target/logs/logServer" + dateName + ".txt";

        appiumServer = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder().withIPAddress(config.getAppiumServer()).usingAnyFreePort()
                        .withLogFile(new File(logFile))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withArgument(() -> "--base-path", "/wd/")
                        .withArgument(() -> "--allow-insecure", "chromedriver_autodownload"));
        appiumServer.start();
    }

    public static void stop() {
        appiumServer.stop();
    }
}

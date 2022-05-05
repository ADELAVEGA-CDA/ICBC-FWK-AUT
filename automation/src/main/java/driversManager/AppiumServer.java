package driversManager;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {
    private static AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildDefaultService();

    public static void start() {
        appiumServer.start();
    }

    public static void stop() {
        appiumServer.stop();
    }
}

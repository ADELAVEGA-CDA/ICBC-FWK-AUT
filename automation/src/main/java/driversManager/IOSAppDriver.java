package driversManager;

import dataProviders.ConfigReader;
import io.appium.java_client.ios.IOSDriver;
import managers.FileReaderMng;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IOSAppDriver {

    private static File fileApp;

    public static IOSDriver loadIphoneEmulator(boolean deviceApp) throws MalformedURLException {
        AppiumServer.start();
        ConfigReader config = FileReaderMng.getInstance().getConfigReader();

        if (deviceApp) {
            File file = new File("src");
            fileApp = new File(file, config.getAppNameIphone());
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformVersion", config.getDeviceVersionIphone());
        cap.setCapability("deviceName", config.getDeviceNameIphone());
        cap.setCapability("automationName", "XCUITest");

        if (deviceApp) {
            cap.setCapability("automationName", "XCUITest");
            cap.setCapability("app", fileApp.getAbsolutePath());
        } else
            cap.setBrowserName("Safari");

        String appiumServer = AppiumServer.appiumServer.getUrl().toString();
        return new IOSDriver(new URL(appiumServer), cap);
    }
}
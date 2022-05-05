package driversManager;

import dataProviders.ConfigReader;
import io.appium.java_client.ios.IOSDriver;
import managers.FileReaderMng;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IOSAppDriver {

    private static IOSDriver driver;
    private static File fileApp;

    public static IOSDriver loadIphoneEmulator(boolean browser) throws MalformedURLException {
        AppiumServer.start();
        ConfigReader config = FileReaderMng.getInstance().getConfigReader();

        if (!browser) {
            File file = new File("src");
            fileApp = new File(file, config.getAppNameIphone()); //set app filepath to /src/[name-of-app-file]
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformVersion", config.getDeviceVersionIphone()); //set the iOS simulator version to be launched
        cap.setCapability("deviceName", config.getDeviceNameIphone()); //set the name of the device to be launched (should be same as AVD)
        cap.setCapability("automationName", "XCUITest"); //set the automation engine to use as XCUITest

        if (browser)
            cap.setBrowserName("Safari"); //set the mobile browser that should be launched on the device
        else {
            cap.setCapability("automationName", "XCUITest"); //set the automation engine to use as XCUITest
            cap.setCapability("app", fileApp.getAbsolutePath()); //set the app to install and use as the one in the filepath specified above
        }

        driver = new IOSDriver(new URL(config.getAppiumServer()), cap); //set the IOSDriver to an Appium session with the above DesiredCapabilities
        return driver;
    }
}
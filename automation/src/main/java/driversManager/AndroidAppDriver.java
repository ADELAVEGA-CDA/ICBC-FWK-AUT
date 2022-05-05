package driversManager;

import dataProviders.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import managers.FileReaderMng;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidAppDriver {

    private static AndroidDriver driver;
    private static File fileApp;

    public static AndroidDriver loadEmulator(boolean browser) throws MalformedURLException {
        AppiumServer.start();
        ConfigReader config = FileReaderMng.getInstance().getConfigReader();

        if (!browser) {
            File file = new File("src");
            fileApp = new File(file, config.getAppNameAndroid()); //set app filepath to /src/[name-of-apk-file]
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("avd", config.getDeviceNameAndroid()); //set the AVD (Android Virtual Device) to be launched
        cap.setCapability("deviceName", config.getDeviceVersionAndroid()); //set the name of the device to be launched (should be same as AVD)

        if (!browser)
            cap.setCapability("app", fileApp.getAbsolutePath()); //set the app to install and use as the one in the filepath specified above
        else {
            cap.setBrowserName("Chromium"); //set the mobile browser that should be launched on the device
            cap.setCapability("app", fileApp.getAbsolutePath()); //set the app to install and use as the one in the filepath specified above

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-first-run"); //ensure Chrome skips any first run Welcome screens when launched
            cap.setCapability("chromeOptions", options);
        }

        driver = new AndroidDriver(new URL(config.getAppiumServer()), cap); //set the AndroidDriver to an Appium session with the above DesiredCapabilities
        return driver;
    }
}
package driversManager;

import dataProviders.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import managers.FileReaderMng;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidAppDriver {

    private static AndroidDriver driver;
    private static File fileApp;

    public static AndroidDriver loadEmulator(boolean deviceApp) throws MalformedURLException {
        AppiumServer.start();
        ConfigReader config = FileReaderMng.getInstance().getConfigReader();

        if (deviceApp) {
            File file = new File("configs/apps");
            fileApp = new File(file, config.getAppNameAndroid()); //set app filepath to /src/[name-of-apk-file]
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getDeviceVersionAndroid());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, config.getDeviceNameAndroid());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

        if (deviceApp) {
            cap.setCapability("app", fileApp.getAbsolutePath()); //set the app to install and use as the one in the filepath specified above
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, config.getAppPackageAndroid()); //set the app to install and use as the one in the filepath specified above
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, config.getAppActivityAndroid()); //set the app to install and use as the one in the filepath specified above
        } else {
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-first-run"); //ensure Chrome skips any first run Welcome screens when launched
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-translate");

            cap.setCapability("chromeOptions", options);

            cap.setCapability("autoDismissAlerts", true);
            cap.setCapability("autoGrantPermissions", true);
            cap.setCapability("autoAcceptAlerts", true);
        }

        String appiumServer = AppiumServer.appiumServer.getUrl().toString();
        driver = new AndroidDriver(new URL(appiumServer), cap); //set the AndroidDriver to an Appium session with the above DesiredCapabilities
        return driver;
    }
}
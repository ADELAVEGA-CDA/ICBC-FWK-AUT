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

    private static File fileApp;

    public static AndroidDriver loadEmulator(boolean deviceApp) throws MalformedURLException {
        AppiumServer.start();
        ConfigReader config = FileReaderMng.getInstance().getConfigReader();

        if (deviceApp) {
            File file = new File("configs/apps");
            fileApp = new File(file, config.getAppNameAndroid());
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getDeviceVersionAndroid());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, config.getDeviceNameAndroid());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

        if (deviceApp) {
            cap.setCapability("app", fileApp.getAbsolutePath());
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, config.getAppPackageAndroid());
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, config.getAppActivityAndroid());
        } else {
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-first-run");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-translate");

            cap.setCapability("chromeOptions", options);

            cap.setCapability("autoDismissAlerts", true);
            cap.setCapability("autoGrantPermissions", true);
            cap.setCapability("autoAcceptAlerts", true);
        }

        String appiumServer = AppiumServer.appiumServer.getUrl().toString();
        return new AndroidDriver(new URL(appiumServer), cap);
    }
}
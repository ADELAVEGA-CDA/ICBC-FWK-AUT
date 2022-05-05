package driversManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;

public class DriverController {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    public static DriverController instance = new DriverController();

    AndroidDriver androidDriver;
    IOSDriver iosDriver;

    public void startNexus5xOreo() throws MalformedURLException {
        if (instance.androidDriver != null) return;
        instance.androidDriver = AndroidAppDriver.loadEmulator(false);
    }

    public void startIphone8() throws MalformedURLException {
        if (instance.iosDriver != null) return;
        instance.iosDriver = IOSAppDriver.loadIphoneEmulator(false);
    }

    public void stopAndroidAppDriver() {
        if (instance.androidDriver == null) return;

        try {
            instance.androidDriver.quit();
        } catch (Exception e) {
            logger.warn(e + ":: AndroidDriver stop error");
        }

        AppiumServer.stop();
        instance.androidDriver = null;
        logger.info(":: AndroidDriver stopped");
    }

    public void stopIOSAppDriver() {
        if (instance.iosDriver == null) return;

        try {
            instance.iosDriver.quit();
        } catch (Exception e) {
            logger.warn(e + ":: IOSDriver stop error");
        }

        AppiumServer.stop();
        instance.iosDriver = null;
        logger.info(":: IOSDriver stopped");
    }
}
package driversManager;

import enums.DriversType;
import enums.Environment;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import managers.FileReaderMng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BrowsersMng {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    private WebDriver driver;
    private AndroidDriver androidDriver;
    private IOSDriver iosDriver;
    private WebDriverWait wait;

    private static DriversType brwType;
    private static Environment ambType;
    private static String webDrvPath;
    private static long waitTime;
    private static boolean device = false;
    private static boolean deviceApp;

    public BrowsersMng() {
        brwType = FileReaderMng.getInstance().getConfigReader().getBrowser();
        ambType = FileReaderMng.getInstance().getConfigReader().getAmbiente();
        webDrvPath = FileReaderMng.getInstance().getConfigReader().getDriverPath();
        deviceApp = FileReaderMng.getInstance().getConfigReader().getDeviceApp();
        waitTime = FileReaderMng.getInstance().getConfigReader().getWaitTime();
    }

    public void setDriver() {
        if (ambType == Environment.LOCAL) {
            initDriver();
            logger.info("__getDrv__local_environment__");
        } else if (ambType == Environment.LOCAL_API) logger.info("__getDrv__api_environment__local_api__");
        else if (ambType == Environment.LOCAL_HEADLESS) {
            initDriver();
            logger.info("__getDrv__local_headless_environment__");
        } else if (ambType == Environment.REMOTO) {
            initDriver();
            logger.info("__getDrv__remote_environment__");
        } else if (ambType == Environment.REMOTO_API) logger.info("__getDrv__api_environment__remoto_api__");
        else if (ambType == Environment.REMOTO_HEADLESS) {
            logger.info("__getDrv__remote_headless_environment__");
        } else throw new RuntimeException("__error_getDrv_Verify__");
    }

    // INIT DRIVERS
    private void initDriver() {
        switch (ambType) {
            case LOCAL:
                createLocal(false);
                logger.info("__initDrv__create_local_drv__");
                break;
            case LOCAL_API:
                logger.info("__create_Drv__local_api__");
                break;
            case LOCAL_HEADLESS:
                createLocal(true);
                logger.info("__create_Drv__local_headless__");
                break;
            case REMOTO:
                createRemoto();
                logger.info("__initDrv__create_remote_drv__");
                break;
            case REMOTO_API:
                logger.info("__create_Drv__remoto_api__");
                break;
            case REMOTO_HEADLESS:
                logger.info("__create_Drv__remoto_headless__");
                break;
            default:
                logger.info("__verify__ambType_case__");
        }
    }

    private WebDriver createRemoto() {
        throw new RuntimeException("__verify__createRemoto_WebDriver__");
    }

    private void createLocal(boolean headless) {
        List<String> args = Arrays.asList("--ignore-certificate-errors");

        switch (brwType) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", webDrvPath + "/geckodriver.exe");
                driver = FirefoxWebDriver.loadDriver(headless);
                logger.info("__driver_new_FirefoxFriver__");
                break;
            case CHROME:
                if (headless)
                    args = Arrays.asList("--headless", "--disable-gpu",
                            "--window-size=1280,800", "--ignore-certificate-errors");

                System.setProperty("webdriver.chrome.driver", webDrvPath + "/chromedriver.exe");
                driver = ChromeWebDriver.loadDriver(args);
                logger.info("__driver_new_ChromeDriver__");
                break;
            case EDGE:
                if (headless)
                    args = Arrays.asList("--headless", "--window-size=1280,800", "--disable-gpu");

                System.setProperty("webdriver.edge.driver", webDrvPath + "/msedgedriver.exe");
                driver = EdgeWebDriver.loadDriver(args);
                logger.info("__driver_new_EdgeDriver__");
                break;
            case SAFARI:
                driver = SafariWebDriver.loadDriver();
                logger.info("__driver_new_EdgeDriver__");
                break;
            case ANDROID:
                device = true;
                try {
                    androidDriver = AndroidAppDriver.loadEmulator(deviceApp);
                    androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
                    wait = new WebDriverWait(androidDriver, Duration.ofSeconds(waitTime));
                } catch (MalformedURLException e) {
                    logger.warn(e + "::Android Emulator bad url");
                }

                logger.info("__driver_new_AndroidDriver__");
                break;
            case IOS:
                device = true;
                try {
                    iosDriver = IOSAppDriver.loadIphoneEmulator(deviceApp);
                    iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
                    wait = new WebDriverWait(iosDriver, Duration.ofSeconds(waitTime));
                } catch (MalformedURLException e) {
                    logger.warn(e + "::Iphone Emulator bad url");
                }

                logger.info("__driver_new_IphoneDriver__");
                break;
            default:
                logger.info("__verify__brwType_case__");
        }

        if (!device) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
            wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        }
    }

    //GETTERS

    public WebDriver getDriver() {
        return driver;
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public boolean isDevice() {
        return device;
    }

    public boolean isDeviceApp() {
        return deviceApp;
    }

    public void closeBrowser() {
        if (ambType == Environment.LOCAL_API || ambType == Environment.REMOTO_API)
            logger.info("__closeBrw__without_browser__");
        else {
            try {
                if (driver != null)
                    driver.quit();
                //driver.close();

                if (device)
                    AppiumServer.stop();
            } catch (Exception e) {
                logger.warn(e + "::WebDriver stop error");
            }

            device = false;
            driver = null;
            logger.info(":: WebDriver stopped");
        }
    }
}

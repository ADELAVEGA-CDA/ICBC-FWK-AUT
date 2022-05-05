package driversManager;

import enums.DriversType;
import enums.Environment;
import managers.FileReaderMng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BrowsersMng {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    private WebDriver driver;
    private static DriversType brwType;
    private static Environment ambType;
    private static String webDrvPath;
    private static long waitTime;
    private static boolean brwSize;
    private static boolean deviceApp;
    private static boolean device = false;

    public BrowsersMng() {
        brwType = FileReaderMng.getInstance().getConfigReader().getBrowser();
        ambType = FileReaderMng.getInstance().getConfigReader().getAmbiente();
        webDrvPath = FileReaderMng.getInstance().getConfigReader().getDriverPath();
        brwSize = FileReaderMng.getInstance().getConfigReader().getBrowserSize();
        deviceApp = FileReaderMng.getInstance().getConfigReader().getDeviceApp();
        waitTime = FileReaderMng.getInstance().getConfigReader().getWaitTime();
    }

    public WebDriver getDrv() {
        if (driver == null) {
            if (ambType == Environment.LOCAL) {
                driver = initDriver();
                logger.info("__getDrv__local_environment__");
            } else if (ambType == Environment.LOCAL_API) logger.info("__getDrv__api_environment__local_api__");
            else if (ambType == Environment.LOCAL_HEADLESS) {
                driver = initDriver();
                logger.info("__getDrv__local_headless_environment__");
            } else if (ambType == Environment.REMOTO) {
                driver = initDriver();
                logger.info("__getDrv__remote_environment__");
            } else if (ambType == Environment.REMOTO_API) logger.info("__getDrv__api_environment__remoto_api__");
            else if (ambType == Environment.REMOTO_HEADLESS) {
                logger.info("__getDrv__remote_headless_environment__");
            } else throw new RuntimeException("__error_getDrv_Verify__");
        }
        return driver;
    }

    // INIT DRIVERS
    private WebDriver initDriver() {
        switch (ambType) {
            case LOCAL:
                driver = createLocal(false);
                logger.info("__initDrv__create_local_drv__");
                break;
            case LOCAL_API:
                logger.info("__create_Drv__local_api__");
                break;
            case LOCAL_HEADLESS:
                driver = createLocal(true);
                logger.info("__create_Drv__local_headless__");
                break;
            case REMOTO:
                driver = createRemoto();
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
        return driver;
    }

    private WebDriver createRemoto() {
        throw new RuntimeException("__verify__createRemoto_WebDriver__");
    }

    private WebDriver createLocal(boolean headless) {
        String args = "";

        switch (brwType) {
            case FIREFOX:
                driver = FirefoxWebDriver.loadFirefoxDriver(headless);
                System.setProperty("webdriver.gecko.driver", webDrvPath);
//                driver = new FirefoxDriver();
                logger.info("__driver_new_FirefoxFriver__");
                break;
            case CHROME:
                if (headless)
                    args = "--headless --disable-gpu --window-size=1280,800 --ignore-certificate-errors";

                driver = ChromeWebDriver.loadChromeDriver(args);
                System.setProperty("webdriver.chrome.driver", webDrvPath);
//                driver = new ChromeDriver();
                logger.info("__driver_new_ChromeDriver__");
                break;
            case EDGE:
                if (headless)
                    args = "--headless --disable-gpu";

                driver = EdgeWebDriver.loadEdgeDriver(args);
                System.setProperty("webdriver.edge.driver", webDrvPath);
                logger.info("__driver_new_EdgeDriver__");
                break;
            case ANDROID:
                device = true;
                try {
                    driver = AndroidAppDriver.loadEmulator(deviceApp);
                } catch (Exception e) {
                    logger.warn(e + "::Android Emulator stop error");
                }

                logger.info("__driver_new_AndroidDriver__");
                break;
            case IOS:
                device = true;
                try {
                    driver = IOSAppDriver.loadIphoneEmulator(deviceApp);
                } catch (Exception e) {
                    logger.warn(e + "::Iphone Emulator stop error");
                }

                logger.info("__driver_new_IphoneDriver__");
                break;
            default:
                logger.info("__verify__brwType_case__");
        }

        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        return driver;
    }

    public void closeBrw() {
        if (ambType == Environment.LOCAL_API || ambType == Environment.REMOTO_API)
            logger.info("__closeBrw__without_browser__");
        else {
            if (driver == null) return;

            try {
                driver.quit();
                driver.close();

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

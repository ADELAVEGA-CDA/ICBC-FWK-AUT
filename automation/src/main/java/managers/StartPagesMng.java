package managers;

import context.TestContext;
import enums.DriversType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.time.Duration.ofSeconds;

public class StartPagesMng {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    protected AndroidDriver androidDriver;
    protected IOSDriver iosDriver;
    protected WebDriver driver;
    protected boolean isDevice;
    protected boolean isDeviceApp;
    protected WebDriverWait wait;
    protected DriversType driverType;

    public StartPagesMng() {
        if (driverType == null) {
            //TestContext.getWebDrvMng().setDriver();

            driverType = FileReaderMng.getInstance().getConfigReader().getBrowser();
            String _url = FileReaderMng.getInstance().getConfigReader().getURL();

            if (driverType == DriversType.ANDROID) {
                androidDriver = TestContext.getWebDrvMng().getAndroidDriver();
                PageFactory.initElements(new AppiumFieldDecorator(androidDriver, ofSeconds(5)), this);

                if (!isDeviceApp)
                    androidDriver.get(_url);
            } else if (driverType == DriversType.IOS) {
                iosDriver = TestContext.getWebDrvMng().getIosDriver();
                PageFactory.initElements(new AppiumFieldDecorator(iosDriver, ofSeconds(5)), this);

                if (!isDeviceApp)
                    iosDriver.get(_url);
            } else {
                driver = TestContext.getWebDrvMng().getDriver();
                PageFactory.initElements(driver, this);

                Boolean _size = FileReaderMng.getInstance().getConfigReader().getBrowserSize();
                if (_size) driver.manage().window().maximize();

                if (!isDeviceApp)
                    driver.get(_url);
            }

            if (!isDeviceApp)
                logger.info("__ToNavigate_" + _url + "__");

            wait = TestContext.getWebDrvMng().getWait();
            isDevice = TestContext.getWebDrvMng().isDevice();
            isDeviceApp = TestContext.getWebDrvMng().isDeviceApp();
        }
    }

    private static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        T page = instantiatePage(driver, pageClassToProxy);
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(15)), page);
        return page;
    }

    private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException var3) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException var4) {
            throw new RuntimeException(var4);
        }
    }

//    // INIT BASE
//    private GlobalParams params;
//    private GlobalRest rest;
//
//    public GlobalParams getGlobalParams() {
//        return (params == null) ? params = new GlobalParams() : params;
//    }
//
//    public GlobalRest getGlobalRest() {
//        return (rest == null) ? rest = new GlobalRest() : rest;
//    }
}

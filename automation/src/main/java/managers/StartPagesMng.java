package managers;

import context.TestContext;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class StartPagesMng {
    protected Logger log = LogManager.getLogger(String.valueOf(this.getClass()));

    protected WebDriver driver;
    protected boolean isDevice;
    protected boolean isDeviceApp;
    protected WebDriverWait wait;

    public StartPagesMng() {
        if (driver == null) {
            String _url = FileReaderMng.getInstance().getConfigReader().getURL();

            driver = TestContext.getWebDrvMng().getDriver();
            wait = TestContext.getWebDrvMng().getWait();
            isDevice = TestContext.getWebDrvMng().isDevice();
            isDeviceApp = TestContext.getWebDrvMng().isDeviceApp();

            if (isDevice)
                PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
            else {
                PageFactory.initElements(driver, this);

                Boolean _size = FileReaderMng.getInstance().getConfigReader().getBrowserSize();
                if (_size) driver.manage().window().maximize();
            }

            if (!isDeviceApp) {
                driver.get(_url);
                log.info("__ToNavigate_" + _url + "__");
            }
        }
    }

//    private static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
//        T page = instantiatePage(driver, pageClassToProxy);
//        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(15)), page);
//        return page;
//    }
//
//    private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
//        try {
//            try {
//                Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
//                return constructor.newInstance(driver);
//            } catch (NoSuchMethodException var3) {
//                return pageClassToProxy.newInstance();
//            }
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException var4) {
//            throw new RuntimeException(var4);
//        }
//    }

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

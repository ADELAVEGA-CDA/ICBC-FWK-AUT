package managers;

import context.TestContext;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public class StartPagesMng {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    protected WebDriver driver;
    protected WebDriverWait wait;
    private Boolean _size = FileReaderMng.getInstance().getConfigReader().getBrowserSize();
    private String _url = FileReaderMng.getInstance().getConfigReader().getURL();

    public StartPagesMng() {
        if (driver == null) {
            driver = TestContext.getWebDrvMng().getDrv();
            wait = TestContext.getWebDrvMng().getWait();
        }

        PageFactory.initElements(driver, this);

        if (_size) driver.manage().window().maximize();
        logger.info("__ToNavigate_" + _url + "__");
        driver.get(_url);
    }

    private static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        T page = instantiatePage(driver, pageClassToProxy);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), page);
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

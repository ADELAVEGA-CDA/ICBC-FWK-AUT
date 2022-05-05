package managers;

import base.GlobalParams;
import base.GlobalRest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public class StartPagesMobileMng {

    public AppiumDriver driver;
    private Boolean _size = FileReaderMng.getInstance().getConfigReader().getBrowserSize();
    private String _url = FileReaderMng.getInstance().getConfigReader().getURL();

    public StartPagesMobileMng(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private static <T> T initElements(AppiumDriver driver, Class<T> pageClassToProxy) {
        T page = instantiatePage(driver, pageClassToProxy);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), page);
        return page;
    }

    private static <T> T instantiatePage(AppiumDriver driver, Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor(AppiumDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException var3) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException var4) {
            throw new RuntimeException(var4);
        }
    }

    // INIT BASE
    private GlobalParams params;
    private GlobalRest rest;

    public GlobalParams getGlobalParams() {
        return (params == null) ? params = new GlobalParams() : params;
    }

    public GlobalRest getGlobalRest() {
        return (rest == null) ? rest = new GlobalRest() : rest;
    }

}

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
}

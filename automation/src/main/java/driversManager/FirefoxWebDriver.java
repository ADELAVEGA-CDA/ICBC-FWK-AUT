package driversManager;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxWebDriver {

    private static RemoteWebDriver driver;

    public static RemoteWebDriver loadFirefoxDriver(boolean headless) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(headless);

        driver = new FirefoxDriver(options);
        return driver;
    }
}
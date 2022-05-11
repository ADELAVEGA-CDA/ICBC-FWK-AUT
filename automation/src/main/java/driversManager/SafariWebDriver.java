package driversManager;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariWebDriver {

    private static RemoteWebDriver driver;

    public static RemoteWebDriver loadDriver() {
        driver = new SafariDriver();
        return driver;
    }
}
package driversManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class ChromeWebDriver {
    private static RemoteWebDriver driver;

    public static RemoteWebDriver loadDriver(List<String> chromeArgument) {
        ChromeDriverService driverService = ChromeDriverService.createDefaultService();

        ChromeOptions options = new ChromeOptions();
        options.addArguments(chromeArgument);

        driver = new ChromeDriver(driverService, options);
        return driver;
    }
}
package driversManager;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class EdgeWebDriver {

    private static RemoteWebDriver driver;

    public static RemoteWebDriver loadDriver(List<String> args) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(args);
        driver = new EdgeDriver(edgeOptions);
        return driver;
    }
}
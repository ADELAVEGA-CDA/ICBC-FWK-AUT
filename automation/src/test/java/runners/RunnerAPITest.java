package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/",
        glue = {"stepsDefinition"},
        tags = "@Api",
        plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:",
                "json:target/reportesCucumber/reporteJSON/rptJSON.json",
        }
)

public class RunnerAPITest {

}

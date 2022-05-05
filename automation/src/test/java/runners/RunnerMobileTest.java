package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/",
        glue = {"stepsDefinition"},
        tags = {"@Mobile"},
        plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:",
                "json:target/reportesCucumber/reporteJSON/rptJSON.json",
        }
)

public class RunnerMobileTest {

}

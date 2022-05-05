package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/",
		glue={"stepsDefinition"},
		tags={"@Api"},
		plugin={"pretty","com.cucumber.listener.ExtentCucumberFormatter:",
				"json:target/reportesCucumber/reporteJSON/rptJSON.json",
		}
	)

public class RunnerAPITest {

}

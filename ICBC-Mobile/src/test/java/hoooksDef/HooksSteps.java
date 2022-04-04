package hoooksDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

public class HooksSteps {
	
	public HooksSteps() {
		
	}

	@Before
	public void beforeSuite() {
		System.out.println("Hooks Before");
		
	}
	
	@After void afterSuite(Scenario sce) {
		System.out.println("Hooks After");
		if (sce.isFailed()) {
			
		}
	}
	
}

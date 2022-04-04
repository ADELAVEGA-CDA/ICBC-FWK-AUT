package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.apache.logging.log4j.ThreadContext;

import globalBase.GlobalParams;
import managers.DriverMng;
import managers.ServerMng;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/resources"},
		glue= {"stepDefs","hooksDefs"},
		tags = "@test",
		plugin = {"pretty",
				"html:target/cucumber"
		}
)

public class RunnerTest {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());
        new ServerMng().startServer();
        new DriverMng().initializeDriver();
    }

    @AfterClass
    public static void quit(){
        DriverMng driverManager = new DriverMng();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerMng serverManager = new ServerMng();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
    }
	
}

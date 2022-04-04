package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.IOException;

import utilsBase.UtilsTest;
import globalBase.GlobalParams;

public class DriverMng {

	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	UtilsTest utils = new UtilsTest();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        PorpertyMng props = new PorpertyMng();

        if(driver == null){
            try{
                utils.log().info("initializing Appium driver");
                switch(params.getPlatformName()){
                    case "Android":
                        driver = new AndroidDriver(new ServerMng().getServer().getUrl(), new CapabilitiesMng().getCaps());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerMng().getServer().getUrl(), new CapabilitiesMng().getCaps());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }
    }
    
}

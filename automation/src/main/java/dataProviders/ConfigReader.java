package dataProviders;

import enums.DriversType;
import enums.Environment;
import enums.SQLDriversType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    private final Properties property;
    private final String message = "__Error_with_the_file_or_the_value__Verify__>>_";

    public ConfigReader() {
        BufferedReader lector;
        try {
            String pathFile = "configs\\config.properties";
            lector = new BufferedReader(new FileReader(pathFile));
            property = new Properties();
            try {
                property.load(lector);
                lector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(message + "_ConfigReader_method__");
        }
    }

    public String getDriverPath() {
        String rutaCHR = property.getProperty("driverPath");
        if (rutaCHR != null) return rutaCHR;
        else throw new RuntimeException(message + "_Path_to_the_file__");
    }

    public long getWaitTime() {
        String time = property.getProperty("waitTime");
        if (time != null) return Long.parseLong(time);
        else throw new RuntimeException(message + "__time_wait_value__");
    }

    public String getURL() {
        String url = property.getProperty("URL");
        if (url != null) return url;
        else throw new RuntimeException(message + "_URL__");
    }

    public Boolean getBrowserSize() {
        String size = property.getProperty("maxWin");
        if (size != null) return Boolean.valueOf(size);
        return true;
    }

    public Boolean getDeviceApp() {
        String deviceApp = property.getProperty("deviceApp");
        if (deviceApp != null) return Boolean.valueOf(deviceApp);
        return true;
    }

    public Environment getAmbiente() {
        String scope = property.getProperty("environment");
        logger.info(">>SCOPE>>" + scope);
        if (scope.equalsIgnoreCase("local")) return Environment.LOCAL;
        else if (scope.equalsIgnoreCase("remote")) return Environment.REMOTO;
        else if (scope.equalsIgnoreCase("local_api")) return Environment.LOCAL_API;
        else if (scope.equalsIgnoreCase("remoto_api")) return Environment.REMOTO_API;
        else if (scope.equalsIgnoreCase("local_headless")) return Environment.LOCAL_HEADLESS;
        else if (scope.equalsIgnoreCase("remoto_headless")) return Environment.REMOTO_HEADLESS;
        else throw new RuntimeException(message + "_error_wiht_the_environment__");
    }

    public DriversType getBrowser() {
        String driverType = property.getProperty("browser");
        if (driverType.equalsIgnoreCase("chrome")) return DriversType.CHROME;
        else if (driverType.equalsIgnoreCase("firefox")) return DriversType.FIREFOX;
        else if (driverType.equalsIgnoreCase("edge")) return DriversType.EDGE;
        else if (driverType.equalsIgnoreCase("safari")) return DriversType.SAFARI;
        else if (driverType.equalsIgnoreCase("android")) return DriversType.ANDROID;
        else if (driverType.equalsIgnoreCase("ios")) return DriversType.IOS;
        else throw new RuntimeException(message + "_error_with_the_driver_type__");
    }

    public String getConfigReporte() {
        String report = property.getProperty("reportConfigPath");
        if (report != null) return report;
        else throw new RuntimeException(message + "_error_with_the-ConfigReporte_path__");
    }

    public String getTestDataPath() {
        String testDataPath = property.getProperty("testDataPath");
        if (testDataPath != null) return testDataPath;
        else throw new RuntimeException(message + "_error_testDataPath_not_specified__");
    }

    public String getReportPath() {
        String reportPath = property.getProperty("reportPath");
        if (reportPath != null) return reportPath;
        else throw new RuntimeException(message + "_error_reportPath_not_specified__");
    }

    public String getSceenshotPath() {
        String screenshotPath = property.getProperty("screenshotPath");
        if (screenshotPath != null) return screenshotPath;
        else throw new RuntimeException(message + "_error_reportScreenshotPath_not_specified__");
    }

    public Boolean getRecordWindows() {
        String screenRecord = property.getProperty("screenRecord");
        if (screenRecord != null) return Boolean.valueOf(screenRecord);
        return true;
    }

    public String getURLdemo() {
        String URLdemo = property.getProperty("URLdemo");
        if (URLdemo != null) return URLdemo;
        else throw new RuntimeException("Err. URLdemo is empty or not defined.");
    }

    public String getAppiumServer() {
        String appiumURL = property.getProperty("appiumURL");
        if (appiumURL != null) return appiumURL;
        else throw new RuntimeException("Err. appiumURL is empty or not defined.");
    }

    public String getAppPackageAndroid() {
        String appPackage = property.getProperty("appPackage");
        if (appPackage != null) return appPackage;
        else throw new RuntimeException("Err. appPackage is empty or not defined.");
    }

    public String getAppActivityAndroid() {
        String appMainActivity = property.getProperty("appMainActivity");
        if (appMainActivity != null) return appMainActivity;
        else throw new RuntimeException("Err. appMainActivity is empty or not defined.");
    }

    public String getAppNameAndroid() {
        String appName = property.getProperty("appNameAndroid");
        if (appName != null) return appName;
        else throw new RuntimeException("Err. appNameAndroid is empty or not defined.");
    }

    public String getDeviceNameAndroid() {
        String deviceName = property.getProperty("deviceNameAndroid");
        if (deviceName != null) return deviceName;
        else throw new RuntimeException("Err. deviceNameAndroid is empty or not defined.");
    }

    public String getDeviceVersionAndroid() {
        String deviceVersion = property.getProperty("deviceVersionAndroid");
        if (deviceVersion != null) return deviceVersion;
        else throw new RuntimeException("Err. deviceVersionAndroid is empty or not defined.");
    }

    public String getAppNameIphone() {
        String appName = property.getProperty("appNameIphone");
        if (appName != null) return appName;
        else throw new RuntimeException("Err. appNameIphone is empty or not defined.");
    }

    public String getDeviceNameIphone() {
        String deviceName = property.getProperty("deviceNameIphone");
        if (deviceName != null) return deviceName;
        else throw new RuntimeException("Err. deviceNameIphone is empty or not defined.");
    }

    public String getDeviceVersionIphone() {
        String deviceVersion = property.getProperty("deviceVersionIphone");
        if (deviceVersion != null) return deviceVersion;
        else throw new RuntimeException("Err. deviceVersionIphone is empty or not defined.");
    }

    public SQLDriversType getDBDriver() {
        String driverType = property.getProperty("browser");
        if (driverType.equalsIgnoreCase("mysql")) return SQLDriversType.MYSQL;
        else if (driverType.equalsIgnoreCase("sqlserver")) return SQLDriversType.SQLSERVER;
        else if (driverType.equalsIgnoreCase("postgres")) return SQLDriversType.POSTGRES;
        else if (driverType.equalsIgnoreCase("oracle")) return SQLDriversType.ORACLE;
        else throw new RuntimeException(message + "_error_with_the_sql_driver_type__");
    }

    public String getDBURL() {
        String URLDataBase = property.getProperty("dbUrl");
        if (URLDataBase != null) return URLDataBase;
        else throw new RuntimeException("Error. URLDataBase is empty or not defined.");
    }

    public String getDBUser() {
        String userDB = property.getProperty("dbUser");
        if (userDB != null) return userDB;
        else throw new RuntimeException(message + "_error_dbUser_not_specified__");
    }

    public String getDBPassword() {
        String passDB = property.getProperty("dbPassword");
        if (passDB != null) return passDB;
        else throw new RuntimeException(message + "_error_dbPassword_not_specified__");
    }
}

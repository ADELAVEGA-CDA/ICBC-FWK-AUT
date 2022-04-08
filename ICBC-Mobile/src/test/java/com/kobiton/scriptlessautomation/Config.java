package com.kobiton.scriptlessautomation;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Config {
    enum DEVICE_SOURCE_ENUMS {KOBITON, SAUCE_LABS}

    public static final String KOBITON_USERNAME = "CDAUser";
    public static final String KOBITON_API_KEY = "4ab8a97e-b52d-42aa-892f-f4b367799dab";
    public static final String APPIUM_SERVER_URL = "https://" + KOBITON_USERNAME + ":" + KOBITON_API_KEY + "@api.kobiton.com/wd/hub";
    public static final DEVICE_SOURCE_ENUMS DEVICE_SOURCE = DEVICE_SOURCE_ENUMS.KOBITON;
    public static final int IMPLICIT_WAIT_IN_SECOND = 30;
    public static final int DEVICE_WAITING_MAX_TRY_TIMES = 5;
    public static final int DEVICE_WAITING_INTERVAL_IN_MS = 30000;
    public static final String KOBITON_API_URL = "https://api.kobiton.com";
    
    public static final String APP_VERSION = "undefined";

    public static String getBasicAuthString() {
        String authString = KOBITON_USERNAME + ":" + KOBITON_API_KEY;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authEncString = new String(authEncBytes);
        return "Basic " + authEncString;
    }
        
    
    public static DesiredCapabilities getSMF711U1Android11DesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("sessionName", "Automation test session");
        capabilities.setCapability("sessionDescription", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("captureScreenshots", true);
        capabilities.setCapability("newCommandTimeout", 15 * 60);
        capabilities.setCapability("ensureWebviewsHavePages", true);
        capabilities.setCapability("kobiton:baselineSessionId", 3973206);
        capabilities.setCapability("kobiton:visualValidation", false);
        capabilities.setCapability("kobiton:textValidation", false);
        capabilities.setCapability("kobiton:flexCorrect", false);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability("deviceGroup", "KOBITON");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-F711U1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        return capabilities;
    }

}
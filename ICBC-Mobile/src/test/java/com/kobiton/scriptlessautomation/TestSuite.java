package com.kobiton.scriptlessautomation;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class TestSuite {
    
    @Test
    public void testOnSMF711U1Android11() throws Exception {
        TestApp testApp = new TestApp();
        DesiredCapabilities capabilities = Config.getSMF711U1Android11DesiredCapabilities();
        testApp.findOnlineDevice(capabilities);
        testApp.setup(capabilities, 1);
        testApp.runTest();
    }

}

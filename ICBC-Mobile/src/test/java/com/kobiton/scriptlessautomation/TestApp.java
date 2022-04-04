package com.kobiton.scriptlessautomation;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestApp extends TestBase {
    public void runTest() throws Exception {
        try {
            updateSettings();
            switchToNativeContext();
            setImplicitWaitInSecond(Config.IMPLICIT_WAIT_IN_SECOND);
            
            setCurrentCommandId(934488596);
            sleep(10599);
            By[] locatorComandroidchromeidurlBar = new By[] {MobileBy.xpath("//*[@resource-id='com.android.chrome:id/url_bar']"), MobileBy.className("android.widget.EditText"), MobileBy.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']"), MobileBy.xpath("//android.widget.EditText[@text='about:blank']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.widget.FrameLayout[2]/android.widget.EditText")};
            MobileElement elementComandroidchromeidurlBar = findElementBy(locatorComandroidchromeidurlBar);
            touchAtRelativePointOfElement(elementComandroidchromeidurlBar, 0.6259689927101135, 0.5199999809265137);
            
            setCurrentCommandId(934488730);
            sleep(4366);
            sendKeys("icbc.com.ar");
            
            setCurrentCommandId(934488818);
            sleep(1830);
            press(PRESS_TYPES.ENTER);
            
            setCurrentCommandId(934489217);
            sleep(20974);
            setImplicitWaitInSecond(Config.IMPLICIT_WAIT_IN_SECOND);
            By[] locatorLinkText = new By[] {MobileBy.linkText("\n								HACETE CLIENTE\n								"), MobileBy.xpath("//a[text()='\n								HACETE CLIENTE\n								']"), MobileBy.xpath("//*[text()='\n								HACETE CLIENTE\n								']"), MobileBy.xpath("/html/body/div/header/div[2]/div/ul/li[2]/a")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorLinkText);
            Rectangle webRectLinkText = getWebElementRect(locatorLinkText);
            switchToNativeContext();
            Rectangle nativeRectLinkText = calculateNativeRect(webRectLinkText);
            touchAtPoint(getAbsolutePoint(0.46388888359069824, 0.37735849618911743, nativeRectLinkText));
            
            setCurrentCommandId(934489431);
            sleep(7473);
            By[] locatorWebView1 = new By[] {MobileBy.xpath("(//android.webkit.WebView)[1]")};
            MobileElement elementWebView1 = findElementBy(locatorWebView1);
            hideKeyboard();
            swipeFromPoint(getAbsolutePoint(0.4555555582046509, 0.8211382031440735, elementWebView1.getRect()), -0.08000001311302185, -0.5024499744176865, 743);
            
            setCurrentCommandId(934489506);
            sleep(2156);
            By[] locatorImg = new By[] {MobileBy.xpath("//*[@class='component-control id-Z7_9216HH42M0E620Q50ERQOOGQP0']//div"), MobileBy.xpath("//*[@class='component-control id-Z7_9216HH42M0E620Q50ERQOOGQP0']//*[@class='po-tit-wit-lis__text po-rich-text-container']")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorImg);
            Rectangle webRectImg = getWebElementRect(locatorImg);
            switchToNativeContext();
            Rectangle nativeRectImg = calculateNativeRect(webRectImg);
            touchAtPoint(getAbsolutePoint(0.39888888597488403, 0.38926175236701965, nativeRectImg));
            
            setCurrentCommandId(934489702);
            sleep(7851);
            By[] locatorDiv = new By[] {MobileBy.xpath("//*[@class='component-control id-Z7_9216HH42M0E620Q50ERQOOGQP0']//div"), MobileBy.xpath("//*[@class='component-control id-Z7_9216HH42M0E620Q50ERQOOGQP0']//*[@class='po-tit-wit-lis__text po-rich-text-container']")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorDiv);
            Rectangle webRectDiv = getWebElementRect(locatorDiv);
            switchToNativeContext();
            Rectangle nativeRectDiv = calculateNativeRect(webRectDiv);
            touchAtPoint(getAbsolutePoint(0.5099999904632568, 0.3836477994918823, nativeRectDiv));
            
            setCurrentCommandId(934491081);
            sleep(51440);
            By[] locatorContactosexo = new By[] {MobileBy.name("contacto.sexo"), MobileBy.cssSelector("select#contacto.sexo"), MobileBy.id("contacto.sexo"), MobileBy.cssSelector("select.browser-default.validate"), MobileBy.cssSelector(".browser-default.validate"), MobileBy.xpath("/html/body/div[1]/div/div/div/main/div/div/div[1]/div/div/section/div/div/div[3]/form/div[1]/div[1]/select")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorContactosexo);
            Rectangle webRectContactosexo = getWebElementRect(locatorContactosexo);
            switchToNativeContext();
            Rectangle nativeRectContactosexo = calculateNativeRect(webRectContactosexo);
            touchAtPoint(getAbsolutePoint(0.4613259732723236, 0.3730158805847168, nativeRectContactosexo));
            
            setCurrentCommandId(934491171);
            sleep(1703);
            By[] locatorCheckedTextViewNoBinarioX = new By[] {MobileBy.xpath("//android.widget.CheckedTextView[@text='No Binario (X)']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.widget.ListView/android.widget.CheckedTextView[4]")};
            touchOnScrollableElement(locatorCheckedTextViewNoBinarioX, "934491171");
            
            setCurrentCommandId(934491208);
            sleep(1415);
            By[] locatorContactodni = new By[] {MobileBy.name("contacto.dni"), MobileBy.cssSelector("input#contacto.dni"), MobileBy.id("contacto.dni"), MobileBy.xpath("/html/body/div[1]/div/div/div/main/div/div/div[1]/div/div/section/div/div/div[3]/form/div[1]/div[2]/input")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorContactodni);
            Rectangle webRectContactodni = getWebElementRect(locatorContactodni);
            switchToNativeContext();
            Rectangle nativeRectContactodni = calculateNativeRect(webRectContactodni);
            touchAtPoint(getAbsolutePoint(0.27871939539909363, 0.565891444683075, nativeRectContactodni));
            
            setCurrentCommandId(934491274);
            sleep(3854);
            By[] locatorViewGroup1 = new By[] {MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[1]")};
            MobileElement elementViewGroup1 = findElementBy(locatorViewGroup1);
            touchAtRelativePointOfElement(elementViewGroup1, 0.5416666865348816, 0.6896551847457886);
            
            setCurrentCommandId(934491336);
            sleep(1185);
            By[] locator0 = new By[] {MobileBy.AccessibilityId("0"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='0']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[14]")};
            MobileElement element0 = findElementBy(locator0);
            touchAtRelativePointOfElement(element0, 0.4333333373069763, 0.37714284658432007);
            
            setCurrentCommandId(934491400);
            sleep(1465);
            By[] locator6 = new By[] {MobileBy.AccessibilityId("6"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='6']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[7]")};
            MobileElement element6 = findElementBy(locator6);
            touchAtRelativePointOfElement(element6, 0.3499999940395355, 0.5428571701049805);
            
            setCurrentCommandId(934491456);
            sleep(820);
            By[] locatorViewGroup3 = new By[] {MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[3]")};
            MobileElement elementViewGroup3 = findElementBy(locatorViewGroup3);
            touchAtRelativePointOfElement(elementViewGroup3, 0.3125, 0.6666666865348816);
            
            setCurrentCommandId(934491515);
            sleep(986);
            By[] locator9 = new By[] {MobileBy.AccessibilityId("9"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='9']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[11]")};
            MobileElement element9 = findElementBy(locator9);
            touchAtRelativePointOfElement(element9, 0.27916666865348816, 0.34857141971588135);
            
            setCurrentCommandId(934491565);
            sleep(1115);
            By[] locator7 = new By[] {MobileBy.AccessibilityId("7"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='7']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[9]")};
            MobileElement element7 = findElementBy(locator7);
            touchAtRelativePointOfElement(element7, 0.34166666865348816, 0.6971428394317627);
            
            setCurrentCommandId(934491598);
            sleep(791);
            By[] locator8 = new By[] {MobileBy.AccessibilityId("8"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='8']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[10]")};
            MobileElement element8 = findElementBy(locator8);
            touchAtRelativePointOfElement(element8, 0.5416666865348816, 0.6971428394317627);
            
            setCurrentCommandId(934491658);
            sleep(812);
            By[] locator4 = new By[] {MobileBy.AccessibilityId("4"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='4']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[5]")};
            MobileElement element4 = findElementBy(locator4);
            touchAtRelativePointOfElement(element4, 0.7208333611488342, 0.46857142448425293);
            
            setCurrentCommandId(934491720);
            sleep(1804);
            By[] locatorNext = new By[] {MobileBy.AccessibilityId("Next"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='Next']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[8]")};
            MobileElement elementNext = findElementBy(locatorNext);
            touchAtRelativePointOfElement(elementNext, 0.550000011920929, 0.5942857265472412);
            
            setCurrentCommandId(934491794);
            sleep(1706);
            By[] locator01 = new By[] {MobileBy.AccessibilityId("0"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='0']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[14]")};
            MobileElement element01 = findElementBy(locator01);
            touchAtRelativePointOfElement(element01, 0.4166666567325592, 0.7257142663002014);
            
            setCurrentCommandId(934491853);
            sleep(563);
            By[] locator02 = new By[] {MobileBy.AccessibilityId("0"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='0']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[14]")};
            MobileElement element02 = findElementBy(locator02);
            touchAtRelativePointOfElement(element02, 0.4166666567325592, 0.7257142663002014);
            
            setCurrentCommandId(934491862);
            sleep(784);
            By[] locator41 = new By[] {MobileBy.AccessibilityId("4"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='4']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[5]")};
            MobileElement element41 = findElementBy(locator41);
            touchAtRelativePointOfElement(element41, 0.4124999940395355, 0.5428571701049805);
            
            setCurrentCommandId(934491937);
            sleep(1013);
            By[] locatorViewGroup2 = new By[] {MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[2]")};
            MobileElement elementViewGroup2 = findElementBy(locatorViewGroup2);
            touchAtRelativePointOfElement(elementViewGroup2, 0.4333333373069763, 0.4195402264595032);
            
            setCurrentCommandId(934491996);
            sleep(549);
            By[] locator5 = new By[] {MobileBy.AccessibilityId("5"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='5']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[6]")};
            MobileElement element5 = findElementBy(locator5);
            touchAtRelativePointOfElement(element5, 0.5416666865348816, 0.3199999928474426);
            
            setCurrentCommandId(934492044);
            sleep(1157);
            By[] locatorViewGroup11 = new By[] {MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[1]")};
            MobileElement elementViewGroup11 = findElementBy(locatorViewGroup11);
            touchAtRelativePointOfElement(elementViewGroup11, 0.44999998807907104, 0.517241358757019);
            
            setCurrentCommandId(934492125);
            sleep(1386);
            By[] locator71 = new By[] {MobileBy.AccessibilityId("7"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='7']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[9]")};
            MobileElement element71 = findElementBy(locator71);
            touchAtRelativePointOfElement(element71, 0.5041666626930237, 0.6000000238418579);
            
            setCurrentCommandId(934492156);
            sleep(1473);
            By[] locatorViewGroup31 = new By[] {MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[3]")};
            MobileElement elementViewGroup31 = findElementBy(locatorViewGroup31);
            touchAtRelativePointOfElement(elementViewGroup31, 0.07916666567325592, 0.5919540524482727);
            
            setCurrentCommandId(934492186);
            sleep(866);
            By[] locator61 = new By[] {MobileBy.AccessibilityId("6"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='6']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[7]")};
            MobileElement element61 = findElementBy(locator61);
            touchAtRelativePointOfElement(element61, 0.02500000037252903, 0.5942857265472412);
            
            setCurrentCommandId(934492248);
            sleep(715);
            By[] locator81 = new By[] {MobileBy.AccessibilityId("8"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='8']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[10]")};
            MobileElement element81 = findElementBy(locator81);
            touchAtRelativePointOfElement(element81, 0.5583333373069763, 0.6000000238418579);
            
            setCurrentCommandId(934492317);
            sleep(1005);
            By[] locator91 = new By[] {MobileBy.AccessibilityId("9"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='9']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[11]")};
            MobileElement element91 = findElementBy(locator91);
            touchAtRelativePointOfElement(element91, 0.0625, 0.6228571534156799);
            
            setCurrentCommandId(934492385);
            sleep(926);
            By[] locator03 = new By[] {MobileBy.AccessibilityId("0"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='0']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[14]")};
            MobileElement element03 = findElementBy(locator03);
            touchAtRelativePointOfElement(element03, 0.6499999761581421, 0.3085714280605316);
            
            setCurrentCommandId(934492450);
            sleep(1851);
            By[] locatorNext1 = new By[] {MobileBy.AccessibilityId("Next"), MobileBy.xpath("//android.view.ViewGroup[@content-desc='Next']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup[8]")};
            MobileElement elementNext1 = findElementBy(locatorNext1);
            touchAtRelativePointOfElement(elementNext1, 0.42500001192092896, 0.5199999809265137);
            
            setCurrentCommandId(934492490);
            sleep(2093);
            By[] locatorCheckTyc = new By[] {MobileBy.xpath("//*[@for='checkTyc']"), MobileBy.cssSelector("label#labelAceptarTyC"), MobileBy.id("labelAceptarTyC"), MobileBy.cssSelector("label.epyf"), MobileBy.cssSelector(".epyf"), MobileBy.xpath("/html/body/div[1]/div/div/div/main/div/div/div[1]/div/div/section/div/div/div[3]/form/div[3]/div/label")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorCheckTyc);
            Rectangle webRectCheckTyc = getWebElementRect(locatorCheckTyc);
            switchToNativeContext();
            Rectangle nativeRectCheckTyc = calculateNativeRect(webRectCheckTyc);
            touchAtPoint(getAbsolutePoint(0.01149425283074379, 0.17777778208255768, nativeRectCheckTyc));
            
            setCurrentCommandId(934492537);
            sleep(2147);
            By[] locatorEventIdNext = new By[] {MobileBy.name("_eventId_next"), MobileBy.cssSelector("input#submit_button"), MobileBy.id("submit_button"), MobileBy.cssSelector("input.waves-effect.waves-light.btn.btn-inicio.btn-block"), MobileBy.cssSelector(".waves-effect.waves-light.btn.btn-inicio.btn-block"), MobileBy.xpath("/html/body/div[1]/div/div/div/main/div/div/div[1]/div/div/section/div/div/div[3]/form/div[5]/input")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorEventIdNext);
            Rectangle webRectEventIdNext = getWebElementRect(locatorEventIdNext);
            switchToNativeContext();
            Rectangle nativeRectEventIdNext = calculateNativeRect(webRectEventIdNext);
            touchAtPoint(getAbsolutePoint(0.4382716119289398, 0.31481480598449707, nativeRectEventIdNext));
            
            setCurrentCommandId(934492593);
            sleep(6796);
            By[] locatorReintentar = new By[] {MobileBy.linkText("Reintentar"), MobileBy.cssSelector("a.waves-effect.waves-light.btn.btn-inicio"), MobileBy.cssSelector(".waves-effect.waves-light.btn.btn-inicio"), MobileBy.xpath("//a[text()='Reintentar']"), MobileBy.xpath("//*[text()='Reintentar']"), MobileBy.xpath("/html/body/div[1]/div/div/div/main/div/div/div[1]/div/div/section/div/div/div/div/div/div[2]/a")};
            hideKeyboard();
            switchToWebContext();
            scrollToWebElement(locatorReintentar);
            Rectangle webRectReintentar = getWebElementRect(locatorReintentar);
            switchToNativeContext();
            Rectangle nativeRectReintentar = calculateNativeRect(webRectReintentar);
            touchAtPoint(getAbsolutePoint(0.7321428656578064, 0.5185185074806213, nativeRectReintentar));
            
            setCurrentCommandId(934492664);
            sleep(4012);
            By[] locatorComandroidsystemuiidhome = new By[] {MobileBy.xpath("//*[@resource-id='com.android.systemui:id/home']"), MobileBy.xpath("//android.widget.ImageView[@resource-id='com.android.systemui:id/home']"), MobileBy.xpath("/hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView[3]")};
            MobileElement elementComandroidsystemuiidhome = findElementBy(locatorComandroidsystemuiidhome);
            touchAtRelativePointOfElement(elementComandroidsystemuiidhome, 0.5020920634269714, 0.4930555522441864);
            
            setCurrentCommandId(934492719);
            sleep(4720);
            press(PRESS_TYPES.POWER);

        } catch (Exception e) {
            saveDebugResource();
            e.printStackTrace();
            throw e;
        } finally {
            cleanup();
        }
    }

    @Override
    public void setup(DesiredCapabilities desiredCaps, double retinaScale) throws Exception {
        super.setup(desiredCaps, retinaScale);
        Reporter.log(String.format("View session at: https://portal.kobiton.com/sessions/%s", getKobitonSessionId()));
    }
}

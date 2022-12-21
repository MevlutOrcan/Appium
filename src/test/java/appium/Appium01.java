package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // capabilities.setCapability("platformName","Android");//String ve selenium methodlari ile
        // capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");//Selenium methodlari ile


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:/Users/Sony/IdeaProjects/AppiumFirst/src/Apps/gestureTool.apk");

        /*
        cmd'ye sırası ıle
        adb shell
        dumpsys window | grep -E "mCurrentFocus"
        yaz gelen bilgileri asagiya yaz eger bunları yapmadan calısmaz ıse
        */

        //adb shell
        //dumpsys window | grep -E "mCurrentFocus"
        //capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        //capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    }
}

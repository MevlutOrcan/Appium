package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // capabilities.setCapability("platformName","Android");//String ve selenium methodlari ile
        // capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");//Selenium methodlari ile


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Sony/IdeaProjects/AppiumFirst/src/Apps/gestureTool.apk");
capabilities.setCapability("noReset",true);
        /*
        cmd'ye sırası ıle
        adb shell
        dumpsys window | grep -E "mCurrentFocus"
        yaz gelen bilgileri asagiya yaz eger bunları yapmadan calısmaz ıse
        */

        //adb shell
        //dumpsys window | grep -E "mCurrentFocus"
        //capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        //capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");


        Thread.sleep(7000);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("App yuklendi");

//        Thread.sleep(7000);
//        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
//        Thread.sleep(5000);
//        MobileElement tamamButton = driver.findElementByXPath("//android.widget.Button[@text='TAMAM']");
//        Thread.sleep(5000);
//        tamamButton.click();
//        System.out.println("Izinler onaylandi");
//
       Thread.sleep(5000);
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");




        //session close
        driver.closeApp();

    }
}

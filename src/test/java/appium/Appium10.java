package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 {

    @Test
    public void test01() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Sony\\IdeaProjects\\AppiumFirst\\src\\Apps\\ApiDemos.apk");

        capabilities.setCapability("noReset", true);


        Thread.sleep(7000);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //Api Demos a tkla

        //preference a tikla
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);

        //preference dependencies e tikla
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        //wifi checkbox u tikla
        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        System.out.println("isChecked = " + isChecked);
//        if (isChecked.equals("false")) {
//            driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\")").click();
//
//        }
        if(driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").isEnabled()){
            driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        }else {
            driver.findElementByXPath("//android.widget.CheckBox").click();
            Thread.sleep(2000);
            driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        }


        Thread.sleep(3000);
        //wi-fi settings e tikla
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();

        // send keys
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/edit\")").sendKeys("text");

        //ok a tikla
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/button1\")").click();


        driver.closeApp();
    }
}

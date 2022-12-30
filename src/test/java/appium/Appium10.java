package appium;

import Appium.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 extends BaseClass {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\USERR\\IdeaProjects\\AppiumFirst\\src\\Apps\\ApiDemos.apk");
        capabilities.setCapability("noReset", true);


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/


                      //********!!!!!!ONEMLİ!!!!!*********//
        //Yukarıdaki kodlari tekrar tekrar yazmamak icin base class olusturduk ve
        // o classa bu classı extends ederek direk methodlari oradan kullanmasini sagladik
        AndroidDriver<MobileElement> driver=getAndroidDriver();
        //Api Demos a tkla

//preference a tikla
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);

//preference dependencies e tikla
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(3000);
//wifi checkbox u tikla
        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        System.out.println("isChecked = " + isChecked);
        if (isChecked.equals("false")) {
            driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\")").click();

        }
        Thread.sleep(3000);
//wi-fi settings e tikla
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(5000);
// send keys
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/edit\")").sendKeys("TextAppium");
        Thread.sleep(3000);
//ok a tikla
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/button1\")").click();
        Thread.sleep(3000);
        // driver.closeApp();

    }
}

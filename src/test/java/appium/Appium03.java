package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability("noReset", true);

        Thread.sleep(7000);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("App yuklendi");
        Thread.sleep(7000);
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Thread.sleep(7000);
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");

        MobileElement testButton = driver.findElementById("com.davemac327.gesture.tool:id/testButton");
        Thread.sleep(7000);

        testButton.click();
        System.out.println("Test button calisti");
        Thread.sleep(7000);
        MobileElement testScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(testScreenTitle.isDisplayed());
        System.out.println("Test Screen acildi");

        //MobileElement canTeamButton = driver.findElementByXPath("//android.widget.TextView[@text='canteam']");
        //Assert.assertTrue(canTeamButton.isDisplayed());

        //session close
        driver.closeApp();

    }
}

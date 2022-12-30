package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseClassiOS {

@Test
    public static IOSDriver<MobileElement> getIOSDriver() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
        capabilities.setCapability("bundleId", "C:\\Users\\Sony\\IdeaProjects\\AppiumFirst\\src\\Apps\\ApiDemos.apk");

        // capabilities.setCapability("appPackage", "com.android.chrome");
        //capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        //capabilities.setCapability("noReset", true);

        Thread.sleep(7000);

    // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}

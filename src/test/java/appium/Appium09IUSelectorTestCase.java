package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium09IUSelectorTestCase {

    @Test
    public void test01() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Sony/IdeaProjects/AppiumFirst/src/Apps/gestureTool.apk");

        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", true);


        Thread.sleep(7000);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //add button a tiklandi
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();

        Thread.sleep(5000);

        String isFalse=driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled");
        Assert.assertEquals(isFalse,"false");

        MobileElement nameTextBox=driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gesture_name\")");
        nameTextBox.sendKeys("text");

        Thread.sleep(5000);


        MobileElement blackSpace=driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gestures_overlay\")");
        blackSpace.click();

        Thread.sleep(5000);
        //add gestrueye tıkladıktan sonra done butonunun aktif olmadıgını false dondugunu sout ıcınde yazdırdık
        String isTrue=driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(true)").getAttribute("enabled");
        Assert.assertEquals(isTrue,"true");

        System.out.println("Done button enabled");

        driver.closeApp();
        /*
            Done buttonunun aktif olup true donmesı ıcın name text box'ina name girip ekrana tiklattik
            Daha sonra enable true ile bunu sout icinde yazdirdik
        */


    }
}

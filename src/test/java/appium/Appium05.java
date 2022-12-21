package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {

    @Test
    public void test01() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Sony\\IdeaProjects\\AppiumFirst\\src\\Apps\\Calculator.apk");

        capabilities.setCapability("noReset", true);

        Thread.sleep(7000);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        MobileElement number1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement number2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement number3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement number4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement number5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement number6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement number7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement number8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement number9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        MobileElement plus = driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement minus = driver.findElementById("com.google.android.calculator:id/op_sub");
        MobileElement multi = driver.findElementById("com.google.android.calculator:id/op_mul");
        MobileElement divide = driver.findElementById("com.google.android.calculator:id/op_div");
        MobileElement equal = driver.findElementById("com.google.android.calculator:id/eq");


        number6.click();number4.click();plus.click();number7.click();number1.click();
        Thread.sleep(1000);
        MobileElement preResult=driver.findElementById("com.google.android.calculator:id/result_preview");
        String prText= preResult.getText();
        equal.click();
        Thread.sleep(5000);
        MobileElement finalResult= driver.findElementById("com.google.android.calculator:id/result_final");
        String resultText= finalResult.getText();

        Assert.assertEquals(prText,resultText);


    }
}

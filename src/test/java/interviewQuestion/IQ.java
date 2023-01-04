package interviewQuestion;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IQ {
    @Test
    public void iqTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/ayyildiz/IdeaProjects/appiumEnglish/Apps/Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        //below capability will rotate the device landscape mode
        desiredCapabilities.setCapability("deviceOrientation","landscape");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SoftAssert softAssert = new SoftAssert();
        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        MobileElement plus  = driver.findElementByAccessibilityId("plus");
        MobileElement equal = driver.findElementByAccessibilityId("equals");
        MobileElement squareRoot = driver.findElementByAccessibilityId("square root");
        MobileElement multiply = driver.findElementById("com.google.android.calculator:id/op_mul");
        MobileElement minus = driver.findElementByAccessibilityId("minus");

        String ex = "-10.862782780491200215723891499337473741120";

        num2.click();
        num3.click();
        plus.click();
        num9.click();
        num5.click();
        equal.click();

        Thread.sleep(5000);
        String resultOfSum = driver.findElementById("com.google.android.calculator:id/result_final").getText();

        squareRoot.click();

        for (int i = 0; i<resultOfSum.length(); i++){
            switch (resultOfSum.charAt(i)){
                case '1':
                    num1.click();
                    break;
                case '2':
                    num2.click();
                    break;
                case '3':
                    num3.click();
                    break;
                case '4':
                    num4.click();
                    break;
                case '5':
                    num5.click();
                    break;
                case '6':
                    num6.click();
                    break;
                case '7':
                    num7.click();
                    break;
                case '8':
                    num8.click();
                    break;
                case '9':
                    num0.click();
                    break;
                case '0':
                    num0.click();
                    break;
            }
        }

        multiply.click();
        minus.click();
        num1.click();
        equal.click();

        String result = driver.findElementById("com.google.android.calculator:id/result_final").getText();

        softAssert.assertEquals(result,ex);

        double exRounded = -10.8628;
//i fyou this code it will not give us rounded number
//        result = result.substring(0,8);
//        System.out.println(result);

        result = result.substring(1);
        System.out.println(result);
        Double doubleResult = Double.valueOf(result);
        System.out.println("after string "+doubleResult);
        double resultRounded = Math.round(doubleResult*10000.0)/10000.0;
        resultRounded = resultRounded * (-1);
        System.out.println("rounded double "+resultRounded);

        softAssert.assertEquals(resultRounded,exRounded,0.0);

        softAssert.assertAll();





    }
}

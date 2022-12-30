package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class Appium03 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
       // capabilities.setCapability("platformName","Android");
        //1.yol manuel olarak yazabılırız(seleniumdan gelir)
     //   capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //Hazır seleniumdan gelen methodlar sayesinde yazabiliriz
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        //Buda appiumdan gelen methodlar sayesinde yazabiliriz.
        //Bu uc yolda aynısını yapar
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //Yukarıda calısacagımız telefonun ozellıklerını verdık

        capabilities.setCapability(MobileCapabilityType.APP,"C:/Users/USERR/IdeaProjects/AppiumFirst/src/Apps/gestureTool.apk");

        /*cmd'ye sırası ıle  adb shell
        dumpsys window | grep -E "mCurrentFocus" yaz gelen bilgileri asagiya yaz eger bunları yapmadan calısmaz ıse*/


        /*
        bu uc satır sayesınde dırek anasayfaya ilerliyoruz appium02 classindaki izin verme adimlarini atlayarak 39. satırda ekledıgımız ile saglariz
         */
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        //Eger aplikasyonu izinler atlayarak ana sayfada acılmasını ıstıyorsanız asagidaki komutu kullanıyoruz
        capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //Benim cihazımın ozellıklerını verdım ve andorıd drıver vasıtası ile ulasıyorum ve capatilities leri bu url ile gonder


       //telefon kilitli ıse ac demek
        if (driver.isDeviceLocked()){
            driver.unlockDevice();
        }
        System.out.println("app yuklendi");

        MobileElement homeScreenTitle=driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");


        MobileElement testButton=driver.findElementById("com.davemac327.gesture.tool:id/testButton");
        testButton.click();
        System.out.println("Test button calısıyor");

        Thread.sleep(3000);
        MobileElement testAGestureTitle=driver.findElementById("android:id/title");
        assertTrue(testAGestureTitle.isDisplayed());
        System.out.println("test screen acildi...");




        //session kapat
        driver.closeApp();

    }
}

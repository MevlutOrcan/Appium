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
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Appium07WebChrome {

    @Test
    public void test01() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Appium methodlari ile
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        //Chrome Driver eskiyse
        //capabilities.setCapability("chromedriverExecutable","chromepath");

        Thread.sleep(7000);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }

        driver.get("https://www.amazon.com");
          String guncelTur=driver.getContext();
        System.out.println(guncelTur+"  <== degisim oncesi context");
        // burda aplikasyonun hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz
        Set<String> tumTurler=driver.getContextHandles();
        for (String w: tumTurler){
            System.out.println(w);
            if (guncelTur.contains("WEBVIEW_chrome")){
                driver.context(guncelTur);
                break;
            }
        }
        System.out.println(guncelTur+"  <== degisim sonrasi context");
        Thread.sleep(3000);

        MobileElement homeScreenLogo = driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        Assert.assertTrue(homeScreenLogo.isDisplayed());


        System.out.println("Ana sayfadayiz");

        Thread.sleep(3000);
        MobileElement signInButton = driver.findElementByXPath("//div[@id=\"nav-progressive-greeting\"]");
        signInButton.click();
        System.out.println("sign in sayfasi");


        Thread.sleep(3000);
        MobileElement createAccount = driver.findElementByXPath("//*[@id=\"register_accordion_header\"]");
        Assert.assertTrue(createAccount.isDisplayed());
        System.out.println("test bitti :)");

        driver.closeApp();


    }
}

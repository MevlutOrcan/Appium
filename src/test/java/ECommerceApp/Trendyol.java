package ECommerceApp;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static ECommerceApp.BaseECommerceApp.getAndroidDriver;

public class Trendyol {
    @Test
    public void testTrendyol() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(3000);
    }
}

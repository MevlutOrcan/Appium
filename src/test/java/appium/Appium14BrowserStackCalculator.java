package appium;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class Appium14BrowserStackCalculator {

    @Test
    public void testCalcuCloud() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "mevlutorcan_JK3TfA");
        caps.setCapability("browserstack.key", "31cDEZnQ6VDznzeLqC9i");

        // Set URL of the application under test
        caps.setCapability("app", "bs://1d56ddb20c693bc6bdefc55985b4f9d9bb32c497");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Google Pixel 3 Appium Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }
}

package appium;

import Appium.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;


import java.net.MalformedURLException;

public class Apppium15Scrolling extends BaseClass {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = getAndroidDriver();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Switches\")").click();

//        Dimension dimension = driver.manage().window().getSize();
//        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
//        int start_x = (int) (dimension.width * 0.5);
//        int start_y = (int) (dimension.height * 0.8);
//
//        int end_x = (int) (dimension.width * 0.5);
//        int end_y = (int) (dimension.height * 0.2);
//
//        TouchAction touchAction = new TouchAction<>(driver);
//
//        for (int i = 0; i < 3; i++) {
//            touchAction.press(PointOption.point(start_x, start_y)).
//                    moveTo(PointOption.point(end_x, end_y)).release().perform();
//        }
//        driver.findElementByXPath("//android.widget.TextView[@text='Switches']").click();
//

    }
}

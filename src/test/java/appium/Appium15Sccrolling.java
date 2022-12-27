package appium;

import Appium.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.sql.Driver;

public class Appium15Sccrolling extends BaseClass {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver=getAndroidDriver();

        Dimension dimension=driver.manage().window().getSize();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        int start_x= (int) (dimension.width*0.5);
        int start_y=(int) (dimension.height*0.8);

        int end_x= (int) (dimension.width*0.5);
        int end_y=(int) (dimension.height*0.2);

        TouchAction touchAction=new TouchAction<>(driver);

        for (int i = 0; i < 3; i++) {
            touchAction.press(PointOption.point(start_x,start_y)).
                    moveTo(PointOption.point(end_x,end_y)).release().perform();
        }
        driver.findElementByXPath("//android.widget.TextView[@text='Switches']").click();




    }
}

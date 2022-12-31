package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static ECommerceApp.BaseECommerceApp.getAndroidDriver;

public class ECommerceAppPositiveTest01 {
    /*
 //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin

//2-Shop the items in the app by scrolling to specific Product and add to cart
//2-Belirli bir Ürüne kaydırarak uygulamadaki öğeleri satın alın ve sepete ekleyin

//3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
//3-Sayfa 2'de seçilen öğelerin ödeme sayfasında görüntülenen öğelerle eşleşip eşleşmediğini doğrulayın

//4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
//4- Ödeme sayfasında görüntülenen toplam Tutarın, alışveriş için seçilen ürün miktarlarının toplamı ile eşleştiğini doğrulayın

//5-Validate Mobile gestures working for link (long press) and navigate to WebView 
//5-Bağlantı için çalışan Mobil hareketleri doğrulayın (uzun basın) ve WebView'a gidin


//6-Verify if user can do operations on Web view and navigate back to native app if needed.
(go to google and search “appium” then navigate to NATIVE APP and verify it)
//-6-Kullanıcının Web görünümünde işlem yapıp yapamayacağını doğrulayın ve gerekirse yerel uygulamaya geri dönün.
(google'a gidin ve "appium"u arayın, ardından NATIVE APP'ye gidin ve doğrulayın)
     */

    @Test
    public void name() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(3000);
        MobileElement homePageTitle = driver.findElementById("com.androidsample.generalstore:id/toolbar_title");
        MobileElement countrySpinner = driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");

        MobileElement nameBox = driver.findElementById("nameField");
        MobileElement radioMale = driver.findElementById("radioMale");
        MobileElement radioFemale = driver.findElementById("radioFemale");
        MobileElement letsShopButton = driver.findElementById("btnLetsShop");

        Assert.assertTrue(homePageTitle.isDisplayed());
        System.out.println("ana sayfadayiz");
        countrySpinner.click();
        System.out.println("ulke secildi");
        String country = "Belgium";
        MobileElement expectedCountry = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))");
        expectedCountry.click();
        System.out.println(country + " tikladi");
        Thread.sleep(3000);
        MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='" + country + "']");
        Assert.assertEquals(selectedCountry.getText(), country);
        System.out.println(country + " secili");
        String sentKeys = "binim bin";
        nameBox.sendKeys(sentKeys);
        Assert.assertEquals(sentKeys, nameBox.getText());
        System.out.println("text is sent");
        if (!radioMale.isSelected()) {
            radioMale.click();
        }
        System.out.println("Male choosed");

        letsShopButton.click();
        System.out.println("Lets Shop Button Clicked");

        Thread.sleep(3000);
        MobileElement productsTitle = driver.findElementByXPath("//android.widget.TextView[@text='Products']");
        Assert.assertTrue(productsTitle.isDisplayed());
        System.out.println("User on the products page");

        MobileElement firstProduct = driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']");
        MobileElement secondProduct = driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']");
        String firstProductName = firstProduct.getText();
        String secondProductName = secondProduct.getText();
        firstProduct.click();
        System.out.println("first product is clicked");


        MobileElement firstProductAddCart = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        firstProductAddCart.click();
        System.out.println("first product clicked");

        MobileElement secondProductAddCart = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        secondProductAddCart.click();
        System.out.println("Second product clicked");
/*
ılk urune tıklamadan ekranda ıkı urun oldugu ıcın ındex olarak locate de 1 ve 2 dememiz gerekiyor du addtocart kısmına
fakat ılk urunde addtocart kısmına tıklayınca yani ılk urunu secınce addtocart addedtocart ta donusuyor ve ıkıncı urunun locate tek indexse donusuyor
Bu yuzden ıkıncıyı sectırırken ılk aldıgımız locate gore [2] yazarsak ve tıklamaya calısırsak hata alırız ılk urun secılınce ıkıncı urun bır konumuna gecıyor ve locatedekı ındex[1] olur

yada bu sorunu cozebılmek mobılelement veraeblesıne atama yapmamız gerekır
 */
        Thread.sleep(3000);

        MobileElement cartButton = driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
        cartButton.click();
        System.out.println("cart button clicked");

        Thread.sleep(3000);
        MobileElement firstProductNameOnTheCartScreen = driver.findElementByXPath("//android.widget.TextView[@text='"+firstProductName+"']");
        Assert.assertEquals(firstProductName, firstProductNameOnTheCartScreen.getText());
        System.out.println("first product in demand is in the cart");

        MobileElement secondProductNameOnTheCartScreen = driver.findElementByXPath("//android.widget.TextView[@text='"+secondProductName+"']");
        Assert.assertEquals(secondProductName, secondProductNameOnTheCartScreen.getText());
        System.out.println("second product in demand is in the cart");

driver.closeApp();
//Popup tam secilmediginde getAttribute ile name alip mesaj icerigi ile assertEquals ediyoruz
        //Eger popup test edılmek ıstenıyorsa ve bu search kod ıcınde bulunmuyorsa yani direk locate edilemiyorsa
//developerlar genelde bunu asagıdaki gibi className= "android.widget.Toast" ile build ederler bizde bu sekilde verify ederiz


    }
}

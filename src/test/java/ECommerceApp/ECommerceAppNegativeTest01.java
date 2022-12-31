package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

import static ECommerceApp.BaseECommerceApp.getAndroidDriver;

public class ECommerceAppNegativeTest01 {
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
        String country = "Angola";
        MobileElement expectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='" + country + "']");
        expectedCountry.click();
        System.out.println("Angolaya tikladi");
        Thread.sleep(5000);
        MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='" + country + "']");
        Assert.assertEquals(selectedCountry.getText(), country);
        System.out.println("Angola secili");

        nameBox.sendKeys("");
        Assert.assertEquals("Enter name here", nameBox.getText());
        System.out.println("text box empty");
        if (!radioFemale.isSelected()) {
            radioFemale.click();
        }
        System.out.println("Female choosed");

        letsShopButton.click();
        System.out.println("Lets Shop Button Clicked");

        MobileElement errorPopUp = driver.findElementByXPath("//android.widget.Toast");
        Thread.sleep(2000);
        Assert.assertEquals("Please enter your name",errorPopUp.getAttribute("name"));
//Popup tam secilmediginde getAttribute ile name alip mesaj icerigi ile assertEquals ediyoruz
        System.out.println("popup is seen");

        //Eger popup test edılmek ıstenıyorsa ve bu search kod ıcınde bulunmuyorsa yani direk locate edilemiyorsa
//developerlar genelde bunu asagıdaki gibi className= "android.widget.Toast" ile build ederler bizde bu sekilde verify ederiz


    }
}

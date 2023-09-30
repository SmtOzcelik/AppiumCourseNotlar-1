package TechProDersleri.tests.Android.Day11_ECommerceApp;

import TechProDersleri.BasePackage.ECommerceAppBaseClass;
import TechProDersleri.screens.androidScreen.ECommence.ECommenceScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class ECommerceLongPrees05 extends ECommerceAppBaseClass {
    /*
    //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
//2-Shop the items in the app by scrolling to specific Product and add to cart
//3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
//4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
//5-Validate Mobile gestures working for link (long press) and navigate to WebView 
//6-Verify if user can do operations on Web view and navigate back to native app if needed.
(go to google and search “appium” then navigate to NATIVE APP and verify it)

     */
    ECommenceScreen eCommenceScreen=new ECommenceScreen();


    @Test
    public void test01() throws InterruptedException, IOException {
        //4- Please read our terms of conditions press yap gelen popup dogrula

        // anasayfada oldugunu dogrula
        String homeScreenText=waitToBeVisiblegetText(eCommenceScreen.homeScreenTitle);
        Assert.assertEquals(homeScreenText,"General Store");

        //country olarak Belgium sec
        //burda kutuyu locate edip Angola send edemiyoruz o yüzden Angola in direk locate aldık
        //önce ülke sec butonu tik yap sonra ülke seç
        waitToBeClickable(eCommenceScreen.countrySpinner);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))"));
        WebElement expectedCountry=driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']"));
        expectedCountry.click();
        //name box samet gir
        driver.findElement(eCommenceScreen.nameBox).click();
        driver.findElement(eCommenceScreen.nameBox).sendKeys("samet");
        Assert.assertEquals(driver.findElement(eCommenceScreen.nameBox).getText(),"samet");
        driver.navigate().back();
        //female tik yap
        waitToBeClickable(eCommenceScreen.femaleRadioButon);

        // lets shop buton tik yap
        waitToBeClickable(eCommenceScreen.letsShopButon);

        // Products sayfasina gectiğini dogrula
        String productsText=waitToBeVisiblegetText(eCommenceScreen.homeScreenTitle);
        Assert.assertEquals(productsText,"Products");

        // ilk ürün seçilsin
        waitToBeClickable(eCommenceScreen.addButon1);

        // ikinci ürün seçilsin fakat burda index yapısı kullanıldığı icin ilk seçtik 2. ilke gectiği icin addbuton1 kullandık
        waitToBeClickable(eCommenceScreen.addButon1);

       // sepete git ve sepette oldugunu dogrula
        waitToBeClickable(eCommenceScreen.sepetButon);
        String cartText=waitToBeVisiblegetText(eCommenceScreen.homeScreenTitle);
        Assert.assertEquals(cartText,"Cart");

        //ilk ürünü dogrula
        String ilkUrun=waitToBeVisiblegetText(eCommenceScreen.airJordon4Retro);
        Assert.assertEquals(ilkUrun,"Air Jordan 4 Retro");

        //ikinci ürünü dogrula
        String ikinciUrun=waitToBeVisiblegetText(eCommenceScreen.airJordan1MidSE);
        Assert.assertEquals(ikinciUrun,"Air Jordan 1 Mid SE");

        // 1. ürünün fiyatın al substring kullanildi
        double firstUrun=Double.parseDouble(driver.findElement(eCommenceScreen.firstProductPrice).getText().substring(1));
        System.out.println("firstUrun = " + firstUrun);

        //2.ürünün fiyatin al replace kullanildi
        double secondUrun=Double.parseDouble(driver.findElement(eCommenceScreen.secondProductPrice).getText().replace("$",""));
        System.out.println("secondUrun = " + secondUrun);

        //Total fiyat al ve dogrula
        double totalFiyat=Double.parseDouble(driver.findElement(eCommenceScreen.totalProductPrice).getText().substring(1));
        System.out.println("totalFiyat = " + totalFiyat);
        Assert.assertEquals(totalFiyat,firstUrun+secondUrun);

        // 'Please read our terms of conditions' termButonu tek tik ile acılmadığını dogrula
        waitToBeClickable(eCommenceScreen.termButon);
        Assert.assertEquals(cartText,"Cart"); // hala sepet ekranındayız acılmadı alert

        //termsBtunonu longPress (uzun bas) yap alert mesajini dogrula
        TouchAction action=new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(driver.findElement(eCommenceScreen.termButon))))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))//burasi acılmasini beklemek icin eklendi
                .release().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(eCommenceScreen.alertTitle));
        Assert.assertTrue(driver.findElement(eCommenceScreen.alertTitle).isDisplayed());

        //alert mesajini kapat ve mesajin kapandığını dogrula
        waitToBeClickable(eCommenceScreen.closeButon);
        Assert.assertEquals(cartText,"Cart");




    }

}

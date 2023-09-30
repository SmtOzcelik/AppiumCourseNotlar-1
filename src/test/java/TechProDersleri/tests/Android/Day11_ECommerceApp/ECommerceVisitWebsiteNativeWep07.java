package TechProDersleri.tests.Android.Day11_ECommerceApp;

import TechProDersleri.BasePackage.ECommerceAppBaseClass;
import TechProDersleri.screens.androidScreen.ECommence.ECommenceScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class ECommerceVisitWebsiteNativeWep07 extends ECommerceAppBaseClass {

    ECommenceScreen eCommenceScreen=new ECommenceScreen();


    @Test
    public void test01() throws InterruptedException, IOException {
        //Nike Blazer Mid '77 , Jordan 6 Rings ürünlerini sec
        //checkbox si tikli hale getir
        // Please read our terms of conditions press yap gelen popup dogrula
        //website ziyaret et

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

        // Nike Blazer Mid '77 ürün seçilsin
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike Blazer Mid '77\"))"));
        waitToBeClickable(eCommenceScreen.addButon1);

        // Jordan 6 Rings ürün seçilsin metod ile scroll yaptık ekranda en üsttedik ürün hep 1. indeks oluyor
        // yani her add to cart butonu ait locate olmuyor
        scrollWithUiScrollable("Jordan 6 Rings");
        waitToBeClickable(eCommenceScreen.addButon1);

       // sepete git ve sepette oldugunu dogrula
        waitToBeClickable(eCommenceScreen.sepetButon);
        String cartText=waitToBeVisiblegetText(eCommenceScreen.homeScreenTitle);
        Assert.assertEquals(cartText,"Cart");

        //ilk ürünü dogrula Nike Blazer Mid '77
        String ilkUrun=waitToBeVisiblegetText(eCommenceScreen.firstUrun);
        Assert.assertEquals(ilkUrun,"Nike Blazer Mid '77");

        //ikinci ürünü dogrula Jordan 6 Rings
        String ikinciUrun=waitToBeVisiblegetText(eCommenceScreen.secondUrun);
        Assert.assertEquals(ikinciUrun,"Jordan 6 Rings");

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
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))//burasi acılmasini beklemek icin eklendi
                .release().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(eCommenceScreen.alertTitle));
        Assert.assertTrue(driver.findElement(eCommenceScreen.alertTitle).isDisplayed());

        //alert mesajini kapat ve mesajin kapandığını dogrula
        waitToBeClickable(eCommenceScreen.closeButon);
        Assert.assertEquals(cartText,"Cart");

        //checkbox tikli olacak
        if (!driver.findElement(eCommenceScreen.checkBox).isSelected()){
            waitToBeClickable(eCommenceScreen.checkBox);
        }

        // proceed buton tik yap
        //tik ten sonra web site ye gececegi icin nativeApp webApp durumunu ayarlamalıyız

        System.out.println((driver.getContext()+" proceed buton tik oncesi tur"));
        waitToBeClickable(eCommenceScreen.proceedButon);
        Thread.sleep(10000); // web sayfasi tam açılması icin koyduk
        System.out.println(driver.getContext()+"proceed buton tik sonrasi tur");
        Set<String>butunTurler=driver.getContextHandles();
        System.out.println("butunTurler = " + butunTurler);
        for (String tur:butunTurler
             ) {
            if (tur.contains("WEBVIEW")){
               // driver.context(tur); //WEBVIEW e gecemedi context hata veriyor NATİVE ile devam
            }
        }
        System.out.println(driver.getContext()+"değişim sonrası hazır olan tur");

        //search box appium yaz
        wait.until(ExpectedConditions.visibilityOfElementLocated(eCommenceScreen.searchBox)).sendKeys("appium");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.Button")).click();

        Thread.sleep(5000);
    }

}

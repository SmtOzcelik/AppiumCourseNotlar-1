package TechProDersleri.tests.Android.Day11_ECommerceApp;

import TechProDersleri.BasePackage.ECommerceAppBaseClass;
import TechProDersleri.screens.androidScreen.ECommence.ECommenceScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class ECommerceNegativeLogin01 extends ECommerceAppBaseClass {
    /*
    //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
//2-Shop the items in the app by scrolling to specific Product and add to cart
//3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
//4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
//5-Validate Mobile gestures working for link (long press) and navigate to WebView //6-Verify if user can do operations on Web view and navigate back to native app if needed.
(go to google and search “appium” then navigate to NATIVE APP and verify it)

     */
    ECommenceScreen eCommenceScreen=new ECommenceScreen();

    @Test
    public void test01() throws InterruptedException {
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
        // negative test name box boş olmalı

        // anasayfada oldugunu dogrula
        String homeScreenText=driver.findElement(eCommenceScreen.homeScreenTitle).getText();
        Assert.assertEquals(homeScreenText,"General Store");

        //country olarak Angola sec
        //burda kutuyu locate edip Angola send edemiyoruz o yüzden Angola in direk locate aldık
        //önce ülke sec butonu tik yap sonra ülke seç
         driver.findElement(eCommenceScreen.countrySpinner).click();

        WebElement expectedCountry=driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']"));
        expectedCountry.click();

        //name box boş olmali
        driver.findElement(eCommenceScreen.nameBox).click();
        driver.findElement(eCommenceScreen.nameBox).clear();
        Assert.assertEquals(driver.findElement(eCommenceScreen.nameBox).getText(),"Enter name here");
        driver.navigate().back();
        //female tik yap
        driver.findElement(eCommenceScreen.femaleRadioButon).click();

        // lets shop buton tik yap
        driver.findElement(eCommenceScreen.letsShopButon).click();

        //popup mesajini dogrula
        String mesaj=driver.findElement(eCommenceScreen.popupMessage).getText();
        Assert.assertEquals(mesaj,"Please enter your name");

    }
    @Test
    public void test02() throws InterruptedException {
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
        // negative test name box boş olmalı

        // anasayfada oldugunu dogrula
        String homeScreenText=driver.findElement(eCommenceScreen.homeScreenTitle).getText();
        Assert.assertEquals(homeScreenText,"General Store");

        //country olarak Turkey sec
        //burda kutuyu locate edip Angola send edemiyoruz o yüzden Angola in direk locate aldık
        //önce ülke sec butonu tik yap sonra ülke seç
        driver.findElement(eCommenceScreen.countrySpinner).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))"));
        WebElement expectedCountry=driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']"));
        expectedCountry.click();
        //name box boş olmali
        driver.findElement(eCommenceScreen.nameBox).click();
        driver.findElement(eCommenceScreen.nameBox).clear();
        Assert.assertEquals(driver.findElement(eCommenceScreen.nameBox).getText(),"Enter name here");
        driver.navigate().back();
        //female tik yap
        driver.findElement(eCommenceScreen.femaleRadioButon).click();

        // lets shop buton tik yap
        driver.findElement(eCommenceScreen.letsShopButon).click();

        //popup mesajini dogrula
        String mesaj=driver.findElement(eCommenceScreen.popupMessage).getText();
        Assert.assertEquals(mesaj,"Please enter your name");

    }

}

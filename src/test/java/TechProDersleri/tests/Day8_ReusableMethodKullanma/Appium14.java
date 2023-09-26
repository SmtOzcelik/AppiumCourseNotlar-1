package TechProDersleri.tests.Day8_ReusableMethodKullanma;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.screens.androidScreen.ApiDemosScreen;
import TechProDersleri.screens.androidScreen.MainScreen;
import TechProDersleri.screens.androidScreen.PreferenceDependenciesScreen;
import TechProDersleri.screens.androidScreen.PreferenceScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;


public class Appium14 extends ApiDemosBaseClass {
    ApiDemosScreen apiDemosScreen=new ApiDemosScreen();
    MainScreen mainScreen=new MainScreen();
    PreferenceScreen preferenceScreen=new PreferenceScreen();
    PreferenceDependenciesScreen preferenceDependenciesScreen=new PreferenceDependenciesScreen();
    @Test
    public void test() throws MalformedURLException, InterruptedException {


        // Test=Wife Setting e samet yazdır

        //continue tik yap
        driver.findElement(mainScreen.contineButon).click();

        //ok tik yap
        driver.findElement(mainScreen.okButon).click();

        //uyari ok tik yap
        driver.findElement(mainScreen.uyariOkButon).click();

        //ana ekranda oldugunu dogrula
        WebElement logo=driver.findElement(mainScreen.apiDemosLogo);
        Assert.assertTrue(logo.isDisplayed());

        //API demos tik yap
        driver.findElement(apiDemosScreen.apiDemosButon).click();

        //Api Demos sayfasinda oldugunu dogrula
        WebElement apiDemosTextt=driver.findElement(apiDemosScreen.apiDemosText);
        Assert.assertTrue(apiDemosTextt.isDisplayed());

        //Preference tik yap
         driver.findElement(apiDemosScreen.preferenceButon).click();

        //Preference dependencies tik yap
        driver.findElement(preferenceScreen.preferenceDependenciesbuton).click();

        //Wifi settings ulaşilamadiğini dogrulayalim enable=false
        String isFalse=driver.findElement(preferenceDependenciesScreen.wifiSettings).getAttribute("enabled");
        Assert.assertEquals(isFalse,"false");

        //wifi kutu tik yap
        driver.findElement(preferenceDependenciesScreen.checkBox).click();

        //wifi setting ulaşılabilir oldugunu dogrula enable=true
        String isTrue=driver.findElement(preferenceDependenciesScreen.wifiSettings).getAttribute("enabled");
        Assert.assertEquals(isTrue,"true");

        //wifi setting tik yap
        driver.findElement(preferenceDependenciesScreen.wifiSettings).click();

        // wifi setting pencersinin acıldığını doğrula
        WebElement cancelText=driver.findElement(preferenceDependenciesScreen.cancelButton);
        Assert.assertTrue(cancelText.isDisplayed());

        //wifi settings text gönder samet olsun
        driver.findElement(preferenceDependenciesScreen.textBox).sendKeys("samet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //ok butonuna tik yap
        wait.until(ExpectedConditions.visibilityOfElementLocated(preferenceDependenciesScreen.okButton)).click();



    }

}

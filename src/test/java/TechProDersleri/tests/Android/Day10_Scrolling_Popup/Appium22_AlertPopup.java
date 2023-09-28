package TechProDersleri.tests.Android.Day10_Scrolling_Popup;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.MetodStepler.ScreenApiDemos;
import TechProDersleri.MetodStepler.ScreenMain;
import TechProDersleri.screens.androidScreen.PopupMenuScreen;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class Appium22_AlertPopup extends ApiDemosBaseClass {

    PopupMenuScreen popupMenuScreen=new PopupMenuScreen();
    @Test
    public void test() throws InterruptedException {

        //Locate verilmeyen Alert Popup mesajın alıp dogrulama

        ScreenMain.contine_tik_yap();
        ScreenMain.ok_tik_yap();
        ScreenMain.uyari_ok_tik_yap();
        ScreenMain.ana_ekranda_oldugunu_dogrula();
        ScreenApiDemos.API_Demos_tik_yap();
        ScreenApiDemos.API_Demos_sayfasinda_oldugunu_dogrula();
        ScreenApiDemos.Views_tik_yap();

        // Popup Menu tik yap
        ReusableMethods.tapOnElementWithText("Popup Menu");

        // Make a popup tik yap
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupMenuScreen.makePopupButton)).click();

        // Search tik yap
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupMenuScreen.searchButton)).click();

        // Popup mesajını onayla
        // isDisplay() ile yakalayamdık o yüzden mesajı alıp icinde olan bi kelimeyi sorgulayarak yapalım
        String message=driver.findElement(popupMenuScreen.popupMessage).getAttribute("name");
        Assert.assertTrue(message.contains("Search"));
        System.out.println("tam mesaj = " + message);


    }
}

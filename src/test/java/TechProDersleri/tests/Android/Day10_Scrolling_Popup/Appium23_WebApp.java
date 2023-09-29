package TechProDersleri.tests.Android.Day10_Scrolling_Popup;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.MetodStepler.Android.ScreenApiDemos;
import TechProDersleri.MetodStepler.Android.ScreenMain;
import TechProDersleri.screens.androidScreen.ApiDemos.PopupMenuScreen;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class Appium23_WebApp extends ApiDemosBaseClass {

    PopupMenuScreen popupMenuScreen=new PopupMenuScreen();
    @Test
    public void test() throws InterruptedException {

        //WepApp e gecerse aplication test

        ScreenMain.contine_tik_yap();
        ScreenMain.ok_tik_yap();
        ScreenMain.uyari_ok_tik_yap();
        ScreenMain.ana_ekranda_oldugunu_dogrula();
        ScreenApiDemos.API_Demos_tik_yap();
        ScreenApiDemos.API_Demos_sayfasinda_oldugunu_dogrula();
        ScreenApiDemos.Views_tik_yap();

        //WebView tik yap
        ReusableMethods.tapOnElementWithText("WebView");

        //Hello World! - 1 tik yap
        ReusableMethods.tapOnElementWithText("Hello World! - 1");

        //tik yaptıktan sonra Native --> Web
        // web e geçmediği icin sistem kodu ona göre yazmadık



    }
}

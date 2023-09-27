package TechProDersleri.tests.Day9_DragandDrop;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.screens.androidScreen.ApiDemosScreen;
import TechProDersleri.screens.androidScreen.DragAndDropScreen;
import TechProDersleri.screens.androidScreen.MainScreen;
import TechProDersleri.screens.androidScreen.ViewsScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.Screenshot;

import java.io.IOException;


public class Appium17MethodKullanarak extends ApiDemosBaseClass {

    MainScreen mainScreen=new MainScreen();

    @Test
    public void test() throws IOException, InterruptedException {


        // Methodları kullanılması

        //continue tik yap
        driver.findElement(mainScreen.contineButon).click();

        //ok tik yap
        driver.findElement(mainScreen.okButon).click();

        //uyari ok tik yap
        driver.findElement(mainScreen.uyariOkButon).click();

        //ana ekranda oldugunu dogrula
        WebElement logo=driver.findElement(mainScreen.apiDemosLogo);
        Assert.assertTrue(logo.isDisplayed());

        /*
        Aşagıdaki metodlar API Demos app icin hazırlanmıştır. istenen Stringler locate hep aynı oldugu icin
        son kismina göre istenilen locate ulaşmış oluryor
         */

        //API Demos tik yap
        ReusableMethods.tapOnElementWithText("API Demos");

        //Api Demos sayfasinda oldugunu dogrula
        ReusableMethods.isElementPresent("API Demos");

        //Preference tik yap
        ReusableMethods.tapOnElementWithText("Preference");


        //ekran görüntüsü al
        Screenshot.screenshot(driver);

    }

}

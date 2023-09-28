package TechProDersleri.tests.Android.Day9_DragandDrop;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.MetodStepler.ScreenApiDemos;
import TechProDersleri.MetodStepler.ScreenMain;
import TechProDersleri.screens.androidScreen.DateWidgetsScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;


public class Appium19_ExpandableLists extends ApiDemosBaseClass {

    DateWidgetsScreen dateWidgetsScreen=new DateWidgetsScreen();
    @Test
    public void test() throws IOException, InterruptedException {


        // Expandable lists test

        ScreenMain.contine_tik_yap();
        ScreenMain.ok_tik_yap();
        ScreenMain.uyari_ok_tik_yap();
        ScreenMain.ana_ekranda_oldugunu_dogrula();
        ScreenApiDemos.API_Demos_tik_yap();
        ScreenApiDemos.API_Demos_sayfasinda_oldugunu_dogrula();
        ScreenApiDemos.Views_tik_yap();

        //Expandable Lists tik yap
        ReusableMethods.tapOnElementWithText("Expandable Lists");

        // 1. Custom Adapter tik yap
        ReusableMethods.tapOnElementWithText("1. Custom Adapter");

        // People Names tik yap
        ReusableMethods.tapOnElementWithText("People Names");

        //Chuck uzun bas
        TouchAction action=new TouchAction(driver);
        WebElement chuck=driver.findElement(By.xpath("//android.widget.TextView[@text='Chuck']"));
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(chuck)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .release().perform();

        // Sample menu görünürlügünü dogrula
        ReusableMethods.isElementPresent("Sample menu");



    }

}

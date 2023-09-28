package TechProDersleri.tests.Android.Day9_DragandDrop;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.MetodStepler.ScreenApiDemos;
import TechProDersleri.MetodStepler.ScreenMain;
import TechProDersleri.screens.androidScreen.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;


public class Appium18_DateWidgets extends ApiDemosBaseClass {

    DateWidgetsScreen dateWidgetsScreen=new DateWidgetsScreen();
    @Test
    public void test() throws IOException, InterruptedException {


        // Date Widgets test

        ScreenMain.contine_tik_yap();
        ScreenMain.ok_tik_yap();
        ScreenMain.uyari_ok_tik_yap();
        ScreenMain.ana_ekranda_oldugunu_dogrula();
        ScreenApiDemos.API_Demos_tik_yap();
        ScreenApiDemos.API_Demos_sayfasinda_oldugunu_dogrula();
        ScreenApiDemos.Views_tik_yap();

        //Date Widgets tik yap
        ReusableMethods.tapOnElementWithText("Date Widgets");

        // 2.Inline tik yap
        ReusableMethods.tapOnElementWithText("2. Inline");

        // 9 tiklansin
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateWidgetsScreen.num9)).click();
        // 15 ten 45 e yeşil topu kaydirsin
        TouchAction action=new TouchAction(driver);

        WebElement num15=driver.findElement(AppiumBy.accessibilityId("15"));
        WebElement num45=driver.findElement(AppiumBy.accessibilityId("45"));

        action.longPress(ElementOption.element(num15))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(ElementOption.element(num45)).release().perform();

    }

}

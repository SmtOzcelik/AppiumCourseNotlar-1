package TechProDersleri.tests.Android.Day9_DragandDrop;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.MetodStepler.Android.ScreenApiDemos;
import TechProDersleri.MetodStepler.Android.ScreenMain;
import TechProDersleri.MetodStepler.Android.ScreenViews;
import TechProDersleri.screens.androidScreen.ApiDemos.ApiDemosScreen;
import TechProDersleri.screens.androidScreen.ApiDemos.DragAndDropScreen;
import TechProDersleri.screens.androidScreen.ApiDemos.MainScreen;
import TechProDersleri.screens.androidScreen.ApiDemos.ViewsScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Screenshot;

import java.io.IOException;


public class Appium16 extends ApiDemosBaseClass {
    ApiDemosScreen apiDemosScreen=new ApiDemosScreen();
    MainScreen mainScreen=new MainScreen();
    ViewsScreen viewsScreen=new ViewsScreen();
    DragAndDropScreen dragAndDropScreen=new DragAndDropScreen();
    @Test
    public void test() throws IOException, InterruptedException {


        ScreenMain.contine_tik_yap();
        ScreenMain.ok_tik_yap();
        ScreenMain.uyari_ok_tik_yap();
        ScreenMain.ana_ekranda_oldugunu_dogrula();
        ScreenApiDemos.API_Demos_tik_yap();
        ScreenApiDemos.API_Demos_sayfasinda_oldugunu_dogrula();
        ScreenApiDemos.Views_tik_yap();
        ScreenViews.Drag_and_Drop_tik_yap();

        //1.topu 2.topun üzerine bırak
         TouchAction action=new TouchAction(driver);
        WebElement dot1=driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_1"));
        WebElement dot2=driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_2"));
                   action.longPress(ElementOption.element(dot1))
                         .moveTo(ElementOption.element(dot2))
                        .release()
                           .perform();
        //4.topun görünürlügünü dogrula
        WebElement yeniTop=driver.findElement(dragAndDropScreen.hiddenDot);
        Assert.assertTrue(yeniTop.isDisplayed());

        //ekran görüntüsü al
        Screenshot.screenshot(driver);

    }

}

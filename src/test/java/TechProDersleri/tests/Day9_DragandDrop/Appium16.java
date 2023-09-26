package TechProDersleri.tests.Day9_DragandDrop;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.screens.androidScreen.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
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


        // Drag and Drop 1.topu 2.topun üzerine bırak

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

       //Views tik yap
        driver.findElement(apiDemosScreen.views).click();

        //Drag and Drop tik yap
        driver.findElement(viewsScreen.dragDropButton).click();

        //1.topu 2.topun üzerine bırak

        TouchAction action=new TouchAction(driver)
                .longPress(ElementOption.element(driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_1"))))
                .moveTo(ElementOption.element(driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_2")))).release().perform();
        //4.topun görünürlügünü dogrula
        WebElement yeniTop=driver.findElement(dragAndDropScreen.hiddenDot);
        Assert.assertTrue(yeniTop.isDisplayed());

        //ekran görüntüsü al
        Screenshot.screenshot(driver);

    }

}

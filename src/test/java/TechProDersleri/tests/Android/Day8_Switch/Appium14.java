package TechProDersleri.tests.Android.Day8_Switch;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.screens.androidScreen.ApiDemos.ApiDemosScreen;
import TechProDersleri.screens.androidScreen.ApiDemos.MainScreen;
import TechProDersleri.screens.androidScreen.ApiDemos.PreferenceScreen;
import TechProDersleri.screens.androidScreen.ApiDemos.SwitchScreen;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Screenshot;

import java.io.IOException;


public class Appium14 extends ApiDemosBaseClass {
    ApiDemosScreen apiDemosScreen=new ApiDemosScreen();
    MainScreen mainScreen=new MainScreen();
    SwitchScreen switchScreen=new SwitchScreen();
    PreferenceScreen preferenceScreen=new PreferenceScreen();
    @Test
    public void test() throws IOException, InterruptedException {


        // switch checkbox tikli ve first switch açık

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

         //Switch tik yap
        driver.findElement(preferenceScreen.switchButton).click();

        //Checkbox tik yap
        WebElement checkBoxx=driver.findElement(switchScreen.checkBox);
        if (!checkBoxx.isSelected()){
            checkBoxx.click();
        }

        //first switch tik yap
        driver.findElement(switchScreen.firstSwitch).click();

        //ekran görüntüsü al
        Screenshot.screenshot(driver);

    }

}

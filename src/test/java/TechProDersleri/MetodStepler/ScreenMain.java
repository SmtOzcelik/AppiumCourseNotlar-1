package TechProDersleri.MetodStepler;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.screens.androidScreen.MainScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.ReusableMethods;

public class ScreenMain extends ApiDemosBaseClass {
    static MainScreen mainScreen=new MainScreen();

    public static void contine_tik_yap(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mainScreen.contineButon)).click();
            System.out.println("Step : contine tik yap ---> PASS ");
        }catch(Exception e){
            System.out.println("contine tik yap hata verdi");
            driver.quit();
        }
    }
    public static void ok_tik_yap(){

        try {
            driver.findElement(mainScreen.okButon).click();
            System.out.println("Step : ok tik yap ---> PASS ");
        }catch(Exception e){
            System.out.println("ok tik yap hata verdi");
            driver.quit();
        }

    }
    public static void uyari_ok_tik_yap(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mainScreen.uyariOkButon)).click();
            System.out.println("Step : uyari ok tik yap ---> PASS ");
        }catch(Exception e){
            System.out.println("uyari ok tik yap hata verdi");
            driver.quit();
        }
    }
    public static void ana_ekranda_oldugunu_dogrula(){

        try {
            WebElement logo=driver.findElement(mainScreen.apiDemosLogo);
            Assert.assertTrue(logo.isDisplayed());
            System.out.println("Step : ana ekranda oldugunu dogrula ---> PASS ");
        }catch(Exception e){
            System.out.println("ana ekranda oldugunu dogrulayamadi");
            driver.quit();
        }
    }
}

package TechProDersleri.MetodStepler;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.screens.androidScreen.ApiDemosScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ScreenApiDemos extends ApiDemosBaseClass {
    static ApiDemosScreen apiDemosScreen=new ApiDemosScreen();

    public static void API_Demos_tik_yap(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(apiDemosScreen.apiDemosButon)).click();
            System.out.println("Step : API Demos tik yap ---> PASS ");
        }catch(Exception e){
            System.out.println("API Demos tik yap hata verdi");
        }
    }
    public static void API_Demos_sayfasinda_oldugunu_dogrula(){

        try {

            WebElement apiDemosTextt=driver.findElement(apiDemosScreen.apiDemosText);
            Assert.assertTrue(apiDemosTextt.isDisplayed());
            System.out.println("Step : API Demos sayfasinda oldugunu dogrula ---> PASS ");
        }catch(Exception e){
            System.out.println("API Demos sayfasinda oldugunu dogrula hata verdi");
        }
    }

    public static void Preference_tik_yap(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(apiDemosScreen.preferenceButon)).click();
            System.out.println("Step : Preference_tik_yap ---> PASS ");
        }catch(Exception e){
            System.out.println("Preference_tik_yap hata verdi");
        }
    }
    public static void Views_tik_yap(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(apiDemosScreen.views)).click();
            System.out.println("Step : Views_tik_yap ---> PASS ");
        }catch(Exception e){
            System.out.println("Views_tik_yap hata verdi");
        }
    }

}

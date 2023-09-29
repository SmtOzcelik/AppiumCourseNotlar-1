package TechProDersleri.MetodStepler.Android;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.screens.androidScreen.ApiDemos.ViewsScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ScreenViews extends ApiDemosBaseClass {
    static ViewsScreen viewsScreen=new ViewsScreen();

    public static void Drag_and_Drop_tik_yap(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(viewsScreen.dragDropButton)).click();
            System.out.println("Step : Drag and Drop tik yap ---> PASS ");
        }catch(Exception e){
            System.out.println("Drag and Drop tik yap hata verdi");
        }
    }




}

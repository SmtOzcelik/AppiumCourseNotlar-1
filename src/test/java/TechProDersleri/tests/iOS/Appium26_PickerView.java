package TechProDersleri.tests.iOS;

import TechProDersleri.BasePackage.BaseClass_iOS;
import TechProDersleri.screens.iosScreen.AlertViewScreen;
import TechProDersleri.screens.iosScreen.MainScreeniOS;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Appium26_PickerView extends BaseClass_iOS {

    MainScreeniOS mainScreeniOS=new MainScreeniOS();
    AlertViewScreen alertViewScreen=new AlertViewScreen();

    @Test
    public void test01() throws InterruptedException {


        //Picker View tik yap
        driver.findElement(mainScreeniOS.pickerView).click();



    }

}

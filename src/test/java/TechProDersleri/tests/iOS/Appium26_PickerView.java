package TechProDersleri.tests.iOS;

import TechProDersleri.BasePackage.BaseClass_iOS;
import TechProDersleri.screens.iosScreen.AlertViewScreen;
import TechProDersleri.screens.iosScreen.MainScreeniOS;
import TechProDersleri.screens.iosScreen.PickerViewScreen;
import com.microsoft.playwright.P;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Appium26_PickerView extends BaseClass_iOS {

    MainScreeniOS mainScreeniOS=new MainScreeniOS();
    PickerViewScreen pickerViewScreen=new PickerViewScreen();

    @Test
    public void test01() throws InterruptedException {


        //Picker View tik yap
        driver.findElement(mainScreeniOS.pickerView).click();

        //Picker view acıldığını dogrula 2 şekilde
        driver.findElement(pickerViewScreen.pickerViewTitle).isDisplayed();

        String text=driver.findElement(pickerViewScreen.pickerViewTitle).getText();
        Assert.assertEquals(text,"Picker View");

        //first Cloum deger ver
        String first="100";
        driver.findElement(pickerViewScreen.firstColumn).sendKeys(first);

        //second Cloum deger ver
        String second="200";
        driver.findElement(pickerViewScreen.secondColumn).sendKeys(second);

        //third Cloum deger ver
        String third="250";
        driver.findElement(pickerViewScreen.thirdColumn).sendKeys(third);

        // verilen degerleri görülmesini dogrula
        Assert.assertEquals(driver.findElement(pickerViewScreen.firstColumn).getText(),first);
        Assert.assertEquals(driver.findElement(pickerViewScreen.secondColumn).getText(),second);
        Assert.assertEquals(driver.findElement(pickerViewScreen.thirdColumn).getText(),third);

    }

}

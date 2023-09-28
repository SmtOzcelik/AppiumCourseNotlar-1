package TechProDersleri.tests.iOS;

import TechProDersleri.BasePackage.BaseClass_iOS_Calcultor;
import TechProDersleri.screens.iosScreen.Calculate_iOS;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Appium28_Calculator extends BaseClass_iOS_Calcultor {
    Calculate_iOS calculateIOS=new Calculate_iOS();
    @Test
    public void test(){
        //10+25 sonucu
        driver.findElement(calculateIOS.num1).click();
        driver.findElement(calculateIOS.num0).click();
        driver.findElement(calculateIOS.arti).click();
        driver.findElement(calculateIOS.num2).click();
        driver.findElement(calculateIOS.num5).click();
        driver.findElement(calculateIOS.equals).click();

        String resultt=driver.findElement(calculateIOS.result).getText();
        Assert.assertEquals(resultt,"35.0");


    }
}

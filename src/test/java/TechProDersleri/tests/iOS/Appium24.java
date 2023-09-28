package TechProDersleri.tests.iOS;

import TechProDersleri.BasePackage.BaseClass_iOS;
import TechProDersleri.screens.iosScreen.AlertViewScreen;
import TechProDersleri.screens.iosScreen.MainScreeniOS;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Appium24 extends BaseClass_iOS {

    MainScreeniOS mainScreeniOS=new MainScreeniOS();
    AlertViewScreen alertViewScreen=new AlertViewScreen();
    @Test
    public void test01() throws InterruptedException {

        // Test = okay/cancel ac ok yap

        // Alert Views tik yap
        driver.findElement(mainScreeniOS.alertViewsButon).click();

        //Okay/Cancel tik yap
        driver.findElement(alertViewScreen.okayCancel).click();

        //popup mesaj dogrula
        String popupMessage=driver.findElement(alertViewScreen.popupText).getAttribute("name");
        Assert.assertEquals(popupMessage,"A Short Title Is Best");
        System.out.println("popupMessage = " + popupMessage);
        //ok tik yap
        driver.findElement(alertViewScreen.okButon);

    }
    @Test
    public void test02() throws InterruptedException {

        // Test = okay/cancal ac cancel yap
        // Alert Views tik yap
        driver.findElement(mainScreeniOS.alertViewsButon).click();

        //Okay/Cancel tik yap
        driver.findElement(alertViewScreen.okayCancel).click();

        //popup mesaj dogrula
        String popupMessage=driver.findElement(alertViewScreen.popupText).getAttribute("name");
        Assert.assertEquals(popupMessage,"A Short Title Is Best");
        //cancel tik yap
        driver.findElement(alertViewScreen.cancelButon);

    }
    @Test
    public void test03() throws InterruptedException {

        // Test = simple ac ok yap
        // Alert Views tik yap
        driver.findElement(mainScreeniOS.alertViewsButon).click();

        //simple tik yap
        driver.findElement(alertViewScreen.simple).click();

        //popup mesaj dogrula
        String popupMessage=driver.findElement(alertViewScreen.popupText).getAttribute("name");
        Assert.assertEquals(popupMessage,"A Short Title Is Best");
        System.out.println("popupMessage = " + popupMessage);
        //ok tik yap
        driver.findElement(alertViewScreen.okButon);

    }
}

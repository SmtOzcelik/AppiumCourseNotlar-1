package TechProDersleri.tests.iOS;

import TechProDersleri.BasePackage.BaseClass_iOS;
import TechProDersleri.screens.iosScreen.AlertViewScreen;
import TechProDersleri.screens.iosScreen.MainScreeniOS;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Appium25_AlertViews extends BaseClass_iOS {

    MainScreeniOS mainScreeniOS=new MainScreeniOS();
    AlertViewScreen alertViewScreen=new AlertViewScreen();

    @Test
    public void test01() throws InterruptedException {

        // Test = Txt entry ac samet yaz ok tik yap
        // Alert Views tik yap
        driver.findElement(mainScreeniOS.alertViewsButon).click();

        //Text entry tik yap
        driver.findElement(alertViewScreen.textEntry).click();

        //popup mesaj dogrula
        String popupMessage=driver.findElement(alertViewScreen.popupText).getAttribute("name");
        Assert.assertEquals(popupMessage,"A Short Title Is Best");
        System.out.println("popupMessage = " + popupMessage);
        // samet yaz
        driver.findElement(alertViewScreen.textbox).sendKeys("samet");

        // ok tik yap
        driver.findElement(alertViewScreen.okButon);

    }
    @Test
    public void test02() throws InterruptedException {

        // Test = Secure Text Entry ac ok tiklananmiyor
        // Alert Views tik yap
        driver.findElement(mainScreeniOS.alertViewsButon).click();

        //Secure Text Entry tik yap
        driver.findElement(alertViewScreen.secureTextEntry).click();

        //popup mesaj dogrula
        String popupMessage=driver.findElement(alertViewScreen.popupText).getAttribute("name");
        Assert.assertEquals(popupMessage,"A Short Title Is Best");
        System.out.println("popupMessage = " + popupMessage);

        // ok butonu tiklanamaz dogrula
        String isEnable=driver.findElement(alertViewScreen.okButon).getAttribute("enabled");
        System.out.println("isEnable = " + isEnable);
        Assert.assertEquals(isEnable,"false");

    }
}

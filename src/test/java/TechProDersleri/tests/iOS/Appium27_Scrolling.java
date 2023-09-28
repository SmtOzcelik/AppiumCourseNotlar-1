package TechProDersleri.tests.iOS;

import TechProDersleri.BasePackage.BaseClass_iOS;
import TechProDersleri.screens.iosScreen.MainScreeniOS;
import TechProDersleri.screens.iosScreen.SwitchesiOSScreen;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Appium27_Scrolling extends BaseClass_iOS {
    MainScreeniOS mainScreeniOS=new MainScreeniOS();
    SwitchesiOSScreen switchesiOSScreen=new SwitchesiOSScreen();

    @Test
    public void test01() {

        // sayfada görünmeyen locate bulana kadar aşagı kaydır yapabilmek icin map oluşturup bilgileri icine at

        // Switches tik yap
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");  // key direction yön
        scrollObject.put("value","Switches");  // key value
        driver.executeScript("mobile:scroll",scrollObject);

        driver.findElement(mainScreeniOS.switches).click();

        //Switchs ekraninda oldugunu dogrula
        driver.findElement(switchesiOSScreen.switchText).isDisplayed();

        // firstSwitch acık olsun
        driver.findElement(switchesiOSScreen.firstSwwith).click();

        //secondSwitch kapalı olsun
        driver.findElement(switchesiOSScreen.secondSwwith).click();

    }
}
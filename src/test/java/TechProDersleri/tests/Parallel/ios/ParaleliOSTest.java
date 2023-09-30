package TechProDersleri.tests.Parallel.ios;

import TechProDersleri.screens.iosScreen.MainScreeniOS;
import TechProDersleri.screens.iosScreen.SwitchesiOSScreen;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
import utilities.Screenshot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class ParaleliOSTest extends ParalleliOSBase{
        MainScreeniOS mainScreeniOS=new MainScreeniOS();
        SwitchesiOSScreen switchesiOSScreen=new SwitchesiOSScreen();
    @Test
    public void test01() throws IOException, InterruptedException {
        IOSDriver driver = getIOSDriver("iPhone14","16.4","F7B2B49D-7732-489D-BD21-ED1F5A29EDC4","8100","10000");
        Thread.sleep(5000);
        // sayfada görünmeyen locate bulana kadar aşagı kaydır yapabilmek icin map oluşturup bilgileri icine at

        // Switches tik yap
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");  // key direction yön
        scrollObject.put("value", "Switches");  // key value
        driver.executeScript("mobile:scroll", scrollObject);

        driver.findElement(mainScreeniOS.switches).click();

        //Switchs ekraninda oldugunu dogrula
        driver.findElement(switchesiOSScreen.switchText).isDisplayed();

        // firstSwitch acık olsun
        String firstText= driver.findElement(switchesiOSScreen.firstSwwith).getText();
        if (firstText.equals("0")) {
            driver.findElement(switchesiOSScreen.firstSwwith).click();
        }

        //secondSwitch kapalı olsun
        String secondText = driver.findElement(switchesiOSScreen.firstSwwith).getText();
        if (secondText.equals("1")) {
            driver.findElement(switchesiOSScreen.secondSwwith).click();

        }
        //Screenshot.screenshot(driver);
        driver.quit();

    }

    @Test
    public void test02() throws IOException, InterruptedException {
        IOSDriver driver = getIOSDriver("iPhone14 Pro Max","16.4","90E3641C-817F-4BFF-82A0-B86B2553D08E","8100","10001");
        Thread.sleep(5000);
        // sayfada görünmeyen locate bulana kadar aşagı kaydır yapabilmek icin map oluşturup bilgileri icine at

        // Switches tik yap
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");  // key direction yön
        scrollObject.put("value", "Switches");  // key value
        driver.executeScript("mobile:scroll", scrollObject);

        driver.findElement(mainScreeniOS.switches).click();

        //Switchs ekraninda oldugunu dogrula
        driver.findElement(switchesiOSScreen.switchText).isDisplayed();

        // firstSwitch acık olsun
        String firstText= driver.findElement(switchesiOSScreen.firstSwwith).getText();
        if (firstText.equals("0")) {
            driver.findElement(switchesiOSScreen.firstSwwith).click();
        }

        //secondSwitch kapalı olsun
        String secondText = driver.findElement(switchesiOSScreen.firstSwwith).getText();
        if (secondText.equals("1")) {
            driver.findElement(switchesiOSScreen.secondSwwith).click();

        }
        //Screenshot.screenshot(driver);
            driver.quit();
    }
}

/** udid bulmak icin xcode de window+devices and similator+similators
 * burdan tel ve dogru versiyonu tik yap Identifer kısmı
 * portları terminalden oluşturuyoruz appium -p 10000 şeklinde enter yap acılır
 */
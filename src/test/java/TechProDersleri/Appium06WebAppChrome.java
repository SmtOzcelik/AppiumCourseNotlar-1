package TechProDersleri;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Appium06WebAppChrome {
    public static AppiumDriver<MobileElement>driver;

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //capabilities.setCapability("noReset","true");//false oldumu tel başa döner,true ayarlar aynı kalır
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"20000");

        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");



        System.out.println(driver.getContext()+"---app acıldıgında tur ---");
        //driver acildiktan sonra 2 tür ilerleme var uygulama hangisinde kurulu ise ona gecip devam etmeliyiz
        // aplikasyonun hangi türde oldugunu görmek icin getContextHandles() kullaniyoruz
        Set<String> butunturler=driver.getContextHandles();
        for (String tur:butunturler
        ) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }
        }
        System.out.println(driver.getContext()+"---degisim sonrasi tur");



        driver.closeApp(); // driver kapatmak icin kullanilir

    }

}

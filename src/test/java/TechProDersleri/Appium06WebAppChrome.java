package TechProDersleri;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Appium06WebAppChrome {
    public static AppiumDriver driver;
    public WebDriverWait wait;

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

        driver=new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");

        System.out.println(((SupportsContextSwitching) driver).getContext()+" app acıldığında tur");
        Set<String>butunturler=((SupportsContextSwitching) driver).getContextHandles();

        System.out.println("butunturler = " + butunturler);
        for (String tur:butunturler
             ) {
            if (tur.contains("WEBVIEW_chrome")){
                ((SupportsContextSwitching) driver).context(tur);
            }

        }
        System.out.println(((SupportsContextSwitching) driver).getContext()+" app acildiktan sonra tur");




        // driver.findElement(By.xpath("//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView")).click();




       // driver.close(); // driver kapatmak icin kullanilir


    }

}

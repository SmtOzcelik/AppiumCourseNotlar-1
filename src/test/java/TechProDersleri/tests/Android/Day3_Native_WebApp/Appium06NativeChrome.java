package TechProDersleri.tests.Android.Day3_Native_WebApp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;


public class Appium06NativeChrome {
    public static AppiumDriver driver;
    public WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","org.chromium.chrome.browser.ChromeTabbedActivity");
        capabilities.setCapability("noReset","true");
        // bu kod sayesinde işlem bitti mi telefonu ilk haline getirir ve tekrar teste hazır olur

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.n11.com");


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


        // anasayfada oldugumuzu dogruladik
        By girisYap=AppiumBy.xpath("//android.view.View[@content-desc=\"Giriş Yap / Üye Ol\"]/android.widget.TextView");
        String girisYapText=wait.until(ExpectedConditions.visibilityOfElementLocated(girisYap)).getText();
        Assert.assertTrue(girisYapText.contains("Giriş Yap / Üye Ol"));

        //sepete tikladik
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Sepetim\"]/android.view.View"))).click();

        //sepetde oldugumuzu dogruladik
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        By sepetBos=AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]");
        String sepetBosText=wait.until(ExpectedConditions.visibilityOfElementLocated(sepetBos)).getText();
        Assert.assertTrue(sepetBosText.contains("Sepetin Boş Görünüyor"));


        driver.quit(); // driver kapatmak icin kullanilir

    }

}

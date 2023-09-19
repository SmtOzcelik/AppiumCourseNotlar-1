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


public class Appium06NativeChrome {
    public static AppiumDriver<MobileElement>driver;
    public WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","org.chromium.chrome.browser.ChromeTabbedActivity");
        capabilities.setCapability("noReset","true");
        // bu kod sayesinde işlem bitti mi telefonu ilk haline getirir ve tekrar teste hazır olur

        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


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



        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        MobileElement homeScreenLogo=driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed()); // amazon sayfasında oldugu dogrulandı

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        MobileElement singInButon= driver.findElementByXPath("//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView");
        singInButon.click();
        MobileElement welcomeText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]");
        Assert.assertEquals(welcomeText.getText(),"Welcome");//Sign sayfasina gectigini dogruladık


        driver.closeApp(); // driver kapatmak icin kullanilir

    }

}

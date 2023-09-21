package TechProDersleri;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium01 {
    public static AppiumDriver driver;
    public WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability("udid","emulator-5554");

        //capabilities.setCapability(MobileCapabilityType.APP,"/Users/sametozcelik/Desktop/AppiumTumDesrler/src/Apps/Gesture Tool_1.3_Apkpure.apk");
        // eger dosya şeklinde ise uygulam Apps den path yolu al direk gir Yok ise aşağıda ki gibi koda dök
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        //capabilities.setCapability("skipUnlock","true");
        //capabilities.setCapability("noReset","false");
        driver=new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));


    }

}

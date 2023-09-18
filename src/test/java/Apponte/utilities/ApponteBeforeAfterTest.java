package Apponte.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApponteBeforeAfterTest {
    public static AppiumDriver<MobileElement>driver;
    public WebDriverWait wait;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","mobi.appcent.apponte");
        capabilities.setCapability("appActivity","mobi.appcent.apponte.ui.activity.login.LoginActivity");
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("noReset","false");
        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver,10);
    }


    @AfterTest
    public void afterTest(){

    }

    public void waitt(int min){

         driver.manage().timeouts().implicitlyWait(min, TimeUnit.SECONDS);
    }

}

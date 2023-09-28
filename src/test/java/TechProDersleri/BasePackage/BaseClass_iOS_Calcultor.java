package TechProDersleri.BasePackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass_iOS_Calcultor {
    public static AppiumDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DesiredCapabilities iOSSafariCaps = new DesiredCapabilities();

        iOSSafariCaps.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 14");
        iOSSafariCaps.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        iOSSafariCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"16.4");
        iOSSafariCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        //iOSSafariCaps.setCapability("appium:browserName", "Safari");
        iOSSafariCaps.setCapability("bundleId","com.hackingwithswift.Calculator");

        driver=new AppiumDriver(new URL("http://127.0.0.1:4723"),iOSSafariCaps);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

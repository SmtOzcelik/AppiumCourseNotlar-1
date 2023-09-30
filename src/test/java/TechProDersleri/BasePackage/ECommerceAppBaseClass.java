package TechProDersleri.BasePackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ECommerceAppBaseClass {
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("app","/Users/sametozcelik/Desktop/AppiumTumDesrler/src/Apps/General-Store.apk");
        capabilities.setCapability("noReset","false");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public static void waitToBeVisible(By element) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitToBeClickable(By element) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }
    public static String waitToBeVisiblegetText(By element) {

       return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();

    }
}

package TechProDersleri.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Appium05 {
    public static AppiumDriver driver;
    public WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/sametozcelik/Desktop/AppiumTumDesrler/src/Apps/Calculator_8.4 (503542421)_Apkpure.apk");
        // uygulama telde yüklü değilse bu şekil
        // eger dosya şeklinde ise uygulam Apps den path yolu al direk gir Yok ise aşağıda ki gibi koda dök


        capabilities.setCapability("noReset","false");
        // bu kod sayesinde işlem bitti mi telefonu ilk haline getirir ve tekrar teste hazır olur

        driver=new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement num1=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1"));
        WebElement num2=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2"));
        WebElement num3=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3"));
        WebElement num4=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_4"));
        WebElement num5=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5"));
        WebElement num6=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_6"));
        WebElement num7=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7"));
        WebElement num8=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_8"));
        WebElement num9=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9"));
        WebElement num0=driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0"));



        WebElement topla=driver.findElement(AppiumBy.accessibilityId("plus"));
        WebElement carpma=driver.findElement(AppiumBy.accessibilityId("multiply"));
        WebElement cikarma=driver.findElement(AppiumBy.accessibilityId("minus"));
        WebElement bolme=driver.findElement(AppiumBy.accessibilityId("divide"));
        WebElement equals=driver.findElement(AppiumBy.accessibilityId("equals"));

        //64+71 işlemini yapalim
        num6.click();
        num4.click();
        topla.click();
        num7.click();
        num1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement preResult= driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
        String preResultText=preResult.getText(); // Atama yaptık çünkü sonuc ekranına gittiği icin değer kayboluyor
        equals.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement finalResult=driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        // finalResult atama yapmadık direk getText yaptık çünkü hala o ekranda
        Assert.assertEquals(finalResult.getText(),preResultText);



        driver.quit(); // driver kapatmak icin kullanilir

    }

}

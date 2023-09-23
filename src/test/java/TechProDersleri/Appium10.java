package TechProDersleri;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Appium10 {
    public static AppiumDriver driver;
    public WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");

        capabilities.setCapability("noReset","false");
        // bu kod sayesinde işlem bitti mi telefonu ilk haline getirir ve tekrar teste hazır olur

        // Test=Wife Setting e Merhaba yazdır
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //continue tik yap
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();

        //ok tik yap
        driver.findElement(By.id("android:id/button1")).click();

        //ok tik yap
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();

        //API demos tik yap
        driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();

        //Preference tik yap
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();

        //Preference dependencies tik yap
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Wifi settings ulaşilamadiğini dogrulayalim enable=false
        String isFalse=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).getAttribute("enabled");
        Assert.assertEquals(isFalse,"false");

        //wifi kutu tik yap
        driver.findElement(By.id("android:id/checkbox")).click();

        //wifi setting ulaşılabilir oldugunu dogrula enable=true
        String isTrue=driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).getAttribute("enabled");
        Assert.assertEquals(isTrue,"true");

        //wifi setting tik yap
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();

        // wifi setting pencersinin acıldığını doğrula
        Assert.assertTrue(driver.findElement(By.id("android:id/alertTitle")).isDisplayed());

        //wifi settings text gönder samet olsun
        driver.findElement(By.id("android:id/edit")).sendKeys("samet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //ok butonuna tik yap
        driver.findElement(By.id("android:id/button1")).click();

        driver.quit(); // driver kapatmak icin kullanilir

    }

}

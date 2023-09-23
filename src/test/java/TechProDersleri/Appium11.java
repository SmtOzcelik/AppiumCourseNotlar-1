package TechProDersleri;

import BasePackage.ApiDemosBaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Appium11 extends ApiDemosBaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        AndroidDriver driver=getAndoridDriver();

        // Test=Wife Setting e samet yazdır Eğer kutu tikli değilse  isSelected() metodu ile

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

        By box=By.id("android:id/checkbox");
        if(!driver.findElement(box).isSelected()){//secili değilse
            // isSelected yerine getAttribute("checked") dan false mi ise şeklinde de yapılır
            //wifi kutu tik yap
            driver.findElement(box).click();

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

        }else { // secili ise
            //wifi setting ulaşılabilir oldugunu dogrula enable=true
            String isTrue=driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).getAttribute("enabled");
            Assert.assertEquals(isTrue,"true");
            System.out.println("wifi box zaten seçili");
        }

        driver.quit(); // driver kapatmak icin kullanilir

    }

}

package TechProDersleri.tests.Day5_Befor_AfterMetod;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;


public class Appium10 extends ApiDemosBaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {


        // Test=Wife Setting e samet yazdır

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


    }

}

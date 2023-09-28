package TechProDersleri.tests.Android.Day6_BrowserStack;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium12BrowserstackAndroid {

    @Test
public void browserstackAndroid() throws MalformedURLException {

        String userName="sametzelik_m4h7nO";// bu bilgileri site kendisi veriyor
        String key="7xuyqMgsHp1cKRx7vAC9";


        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("browserstack.user",userName);
        capabilities.setCapability("browserstack.key",key);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability("app","bs://6837a629be27d35e524370c9edefab433d7a2668");
        //Bu kod app i yükleyince kendisi veriyor
        capabilities.setCapability("browserstackLocal",true);
        capabilities.setCapability("project","Appium Project");
        capabilities.setCapability("build","browserstack-1");
        capabilities.setCapability("name","sample_test");
        //verileri caps icine doldur aşağıdaki url yi güncelledikten sonra localde değilde bulutta calışıyor
        // tek fark testin uzakta calışması ve yukarıdaki proje isimleri değişik şekilde yazılabilr

        AndroidDriver driver=new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"),capabilities);

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

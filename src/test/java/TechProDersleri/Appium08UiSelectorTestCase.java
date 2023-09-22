package TechProDersleri;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Appium08UiSelectorTestCase {
    public static AppiumDriver driver;
    public WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

        capabilities.setCapability("noReset","false");
        // bu kod sayesinde işlem bitti mi telefonu ilk haline getirir ve tekrar teste hazır olur

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        https://developer.android.com/reference/androidx/test/uiautomator/UiSelector verilere ulaşilacak link
        sadece android testlerinde kullanılır. fazla kullanışlı değil method şeklinde çağrılmiyor string olarak
        elle giriliyor. hepsini yapmadık belli başlıları tercih ettik.
         */

        //driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"com.android.permissioncontroller:id/continue_button\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/button1\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartWith(\"Add\")")).click(); yukarıda id ile yaptık

        // burda name yerine bi şeyler yazılmadığı icin done aktif değil onun testini yapalim enable=false durumu
        String isFalse=driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)")).getAttribute("enabled");
        Assert.assertEquals(isFalse,"false"); //false string olarak döneceği icin "" kullandık

        // şimdi box içinde yazalim ki Done tıklanabilir enable=true durumuna gelsin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gesture_name\")")).sendKeys("Samet");
        Thread.sleep(5);
        WebElement blackScreen=driver.findElement(AppiumBy.id("com.davemac327.gesture.tool:id/gestures_overlay"));
        blackScreen.click();


        Thread.sleep(3);


        //şimdi de done butuonu ulaşilabilir tıklanabilir enable=true halde mi onu dogruluyalim
        String isTrue=driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(true)")).getAttribute("enabled");
        Assert.assertEquals(isTrue,"true");

        System.out.println("Done button aktif");


        /*
        1- Id locate olursa kullanimi bu şekilde al tik yap
        driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(locateyeri)").click();
        2-className locet olursa kullanimi
        driver.findElement(AppiumBy.androidUIAutomator("UiSelector().className(locateyeri)").click();
          eger 3 tane locate çıkıyorsa index(0) ekle
          driver.findElement(AppiumBy.androidUIAutomator("UiSelector().className(locateyeri).index(0)").click();

          veya 3 tanesinden text i biliniyor ise text=Test olsun
          driver.findElement(AppiumBy.androidUIAutomator("UiSelector().className(locateyeri).text("Test")").click();

          veya TextstartsWith kullanarak class i qunik yaparız
          driver.findElement(AppiumBy.androidUIAutomator("UiSelector().className(locateyeri).TextstartsWith("Te")").click();

         */


        driver.quit(); // driver kapatmak icin kullanilir

    }

}

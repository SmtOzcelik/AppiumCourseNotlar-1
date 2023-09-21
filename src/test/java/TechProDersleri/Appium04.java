package TechProDersleri;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
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


public class Appium04 {
    public static AppiumDriver driver;
    public WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        //capabilities.setCapability(MobileCapabilityType.APP,"/Users/sametozcelik/Desktop/AppiumTumDesrler/src/Apps/Gesture Tool_1.3_Apkpure.apk");
        // uygulama telde yüklü değilse bu şekil
        // eger dosya şeklinde ise uygulam Apps den path yolu al direk gir Yok ise aşağıda ki gibi koda dök
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

        capabilities.setCapability("noReset","false");
        // bu kod sayesinde işlem bitti mi telefonu ilk haline getirir ve tekrar teste hazır olur

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("app yüklendi");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement okButton=driver.findElement(By.id("android:id/button1"));
        okButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement homeScreenTitle=driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acıldi");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement addGestureButon=driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton"));
        addGestureButon.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement createGestureText=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.TextView"));
        System.out.println(createGestureText.getText().toString());
        Assert.assertTrue(createGestureText.getText().contains("Create a gesture"));
        System.out.println("add Gesture sayfasi acıldi");
        WebElement nameBox=driver.findElement(By.id("com.davemac327.gesture.tool:id/gesture_name"));
        nameBox.sendKeys("samet");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement ekran=driver.findElement(By.id("com.davemac327.gesture.tool:id/gestures_overlay"));
        ekran.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement doneButon=driver.findElement(By.id("com.davemac327.gesture.tool:id/done"));
        doneButon.click();




        driver.close(); // driver kapatmak icin kullanilir

    }

}

package TechProDersleri;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Appium05 {
    public static AppiumDriver<MobileElement>driver;
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

        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        MobileElement num1=driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2=driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3=driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4=driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5=driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6=driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7=driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8=driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9=driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0=driver.findElementById("com.google.android.calculator:id/digit_0");

        MobileElement topla=driver.findElementByAccessibilityId("plus");
        MobileElement carpma=driver.findElementByAccessibilityId("multiply");
        MobileElement cikarma=driver.findElementByAccessibilityId("minus");
        MobileElement bolme=driver.findElementByAccessibilityId("divide");
        MobileElement equals=driver.findElementByAccessibilityId("equals");

        //64+71 işlemini yapalim
        num6.click();
        num4.click();
        topla.click();
        num7.click();
        num1.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        MobileElement preResult= driver.findElementById("com.google.android.calculator:id/result_preview");
        String preResultText=preResult.getText(); // Atama yaptık çünkü sonuc ekranına gittiği icin değer kayboluyor
        equals.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        MobileElement finalResult=driver.findElementById("com.google.android.calculator:id/result_final");
        // finalResult atama yapmadık direk getText yaptık çünkü hala o ekranda
        Assert.assertEquals(finalResult.getText(),preResultText);



        //driver.closeApp(); // driver kapatmak icin kullanilir

    }

}

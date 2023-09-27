package utilities;


import TechProDersleri.BasePackage.ApiDemosBaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ReusableMethods extends ApiDemosBaseClass {
    // bu metodlar apiDemos uygulamasında locateler hep text üzerinden oldugu icin ona göre düzenlmiştir.
    // başka yerlerde kullanılacaksa düzenlenip application a göre şekillendirilir

         public static void tapOnElementWithText(String text) {
             //elemente tik yap o anda bulamazsan scroll yap bul tik yap en kapsamlısı bu oldu
            List<WebElement> mobileElementList = driver.findElements(By.className("android.widget.TextView"));
            for (WebElement page: mobileElementList
            ) {
                if (page.getText().equals(text)){
                    page.click();
                }else{
                    scrollWithUiScrollable(text);
                }
                break;
            }
        }

//ikinci alternatif bir method
        public static void clickOnElementWithText(String elementText) throws InterruptedException {
            Thread.sleep(4000);
            List<WebElement> mobileElementList = driver.findElements(By.xpath("//android.widget.TextView[@text='"+elementText+"']"));
            if (mobileElementList.size()>0){
                mobileElementList.get(0).click();
            }else scrollWithUiScrollable(elementText);
        }


    public static boolean isElementPresent(String text) {
        // element görünüyor mu?
        boolean elementFound = false;
        List<WebElement> mobileElementList = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        for (WebElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, 10);
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tapOn(WebElement element) {
        waitToBeClickable(element, 10);
        element.click();
    }

    public static void enterText(WebElement element, String text) {
        waitToBeClickable(element, 10);
        element.sendKeys(text);
    }

    public static void enterText(WebElement element, String text, boolean needClear) {
        waitToBeClickable(element, 10);
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public static boolean isElementPresent(WebElement mobileElement) {
        boolean elementFound = false;
        waitToBeVisible(mobileElement, 10);
        if (mobileElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    public static void waitToBeVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollWithUiScrollable(String elementText) {
        // elementi ara bul scroll yap tik yap
        AndroidDriver driverr = (AndroidDriver)driver ;
        driverr.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))"));
        tapOn(driverr.findElement(By.xpath("//android.widget.TextView[@text='" + elementText + "']")));
    }



}

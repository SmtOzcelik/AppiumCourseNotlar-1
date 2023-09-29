package TechProDersleri.screens.androidScreen.ECommence;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ECommenceScreen {
    public By letsShopButon= AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
   public By popupMessage=AppiumBy.xpath("//android.widget.Toast");
   public By homeScreenTitle=AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
   public By maleRadioButon=AppiumBy.id("com.androidsample.generalstore:id/radioMale");
   public By femaleRadioButon=AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    public By nameBox=AppiumBy.id("com.androidsample.generalstore:id/nameField");
    public By countrySpinner=AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");

}

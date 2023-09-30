package TechProDersleri.screens.androidScreen.ECommence;

import io.appium.java_client.AppiumBy;
import org.eclipse.jetty.deploy.App;
import org.openqa.selenium.By;

public class ECommenceScreen {
    public By letsShopButon= AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
   public By popupMessage=AppiumBy.xpath("//android.widget.Toast");
   public By homeScreenTitle=AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
   public By maleRadioButon=AppiumBy.id("com.androidsample.generalstore:id/radioMale");
   public By femaleRadioButon=AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    public By nameBox=AppiumBy.id("com.androidsample.generalstore:id/nameField");
    public By countrySpinner=AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    public By addButon1=AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
    public By addButon2=AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[2]");
    public By sepetButon=AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
    public By airJordon4Retro= AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']");
    public By airJordan1MidSE=AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']");
    public By firstProductPrice=AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])[1]");
    public By secondProductPrice=AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])[2]");
    public By totalProductPrice=AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");
    public By termButon=AppiumBy.id("com.androidsample.generalstore:id/termsButton");
    public By alertTitle=AppiumBy.id("com.androidsample.generalstore:id/alertTitle");
    public By closeButon=AppiumBy.id("android:id/button1");

}

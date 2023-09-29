package TechProDersleri.screens.androidScreen.ApiDemos;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;

public class PopupMenuScreen {

    public By makePopupButton= AppiumBy.className("android.widget.Button");
    public By popupMessage=AppiumBy.xpath("//android.widget.Toast");
    public By searchButton=AppiumBy.xpath("//android.widget.TextView[@text='Search']");
    public By webViewButton=AppiumBy.xpath("//android.widget.TextView[@text='WebView']");
}

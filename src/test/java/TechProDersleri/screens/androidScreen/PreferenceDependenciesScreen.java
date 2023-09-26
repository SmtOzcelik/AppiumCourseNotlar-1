package TechProDersleri.screens.androidScreen;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PreferenceDependenciesScreen {

    public By checkBox= AppiumBy.id("android:id/checkbox");
    public By wifiSettings=AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']");
    public By cancelButton=AppiumBy.id("android:id/button2");
    public By okButton=AppiumBy.id("android:id/button1");
    public By textBox=AppiumBy.id("android:id/edit");

}

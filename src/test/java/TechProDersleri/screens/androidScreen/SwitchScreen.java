package TechProDersleri.screens.androidScreen;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;


public class SwitchScreen {


    public By checkBox= AppiumBy.id("android:id/checkbox");
    public By firstSwitch=AppiumBy.xpath("(//android.widget.Switch)[1]");
    public By secondSwitch=AppiumBy.xpath("(//android.widget.Switch)[2]");


}

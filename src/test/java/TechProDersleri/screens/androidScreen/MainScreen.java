package TechProDersleri.screens.androidScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public class MainScreen {

    public By contineButon= AppiumBy.id("com.android.permissioncontroller:id/continue_button");
    public By okButon=AppiumBy.id("android:id/button1");
    public By uyariOkButon=AppiumBy.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
    public By apiDemosLogo=AppiumBy.xpath("(//android.widget.ImageView)[1]");

}

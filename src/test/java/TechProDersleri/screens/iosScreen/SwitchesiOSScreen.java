package TechProDersleri.screens.iosScreen;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class SwitchesiOSScreen {

    public By firstSwwith= AppiumBy.xpath("(//XCUIElementTypeSwitch)[1]");
    public By secondSwwith= AppiumBy.xpath("(//XCUIElementTypeSwitch)[2]");
    public By switchText=AppiumBy.className("XCUIElementTypeStaticText");


}

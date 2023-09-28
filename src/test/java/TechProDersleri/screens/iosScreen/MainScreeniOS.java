package TechProDersleri.screens.iosScreen;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MainScreeniOS {
        // locate icin accessibility id, iosclasschain , iospredicate
    public By alertViewsButon= AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Alert Views\"`]");
    public By buttons=AppiumBy.accessibilityId("Buttons");
   public By datePicker=AppiumBy.accessibilityId("Date Picker");
    public By ımageView=AppiumBy.accessibilityId("Image View");
    public  By pageControl=AppiumBy.accessibilityId("Page Control");
    public By pickerView=AppiumBy.accessibilityId("Picker View");
    public By progressViews=AppiumBy.accessibilityId("Progress Views");
    public By search=AppiumBy.accessibilityId("Search");

}

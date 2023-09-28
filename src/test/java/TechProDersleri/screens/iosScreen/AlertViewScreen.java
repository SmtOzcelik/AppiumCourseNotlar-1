package TechProDersleri.screens.iosScreen;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class AlertViewScreen {
    public By textEntry= AppiumBy.accessibilityId("Text Entry");
    public By simple= AppiumBy.accessibilityId("Simple");
    public By okButon= AppiumBy.accessibilityId("OK");
    public By okayCancel= AppiumBy.accessibilityId("Okay / Cancel");
    public By other= AppiumBy.accessibilityId("Other");
    public By popupText=AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"A Short Title Is Best\"`]");
    public By cancelButon= AppiumBy.accessibilityId("Cancel");
    public By choiceOneButon= AppiumBy.accessibilityId("Choice One");
    public By choiceTwoButon= AppiumBy.accessibilityId("Choice Two");
    public By textbox=AppiumBy.className("XCUIElementTypeTextField");
    public By secureTextEntry=AppiumBy.accessibilityId("Secure Text Entry");


}

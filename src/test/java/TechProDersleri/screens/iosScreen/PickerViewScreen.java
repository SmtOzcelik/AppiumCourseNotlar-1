package TechProDersleri.screens.iosScreen;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;



public class PickerViewScreen {
    public By firstColumn= AppiumBy.accessibilityId("Red color component value");
    public By secondColumn= AppiumBy.accessibilityId("Green color component value");
    public By thirdColumn= AppiumBy.accessibilityId("Blue color component value");
    public By pickerViewTitle= AppiumBy.className("XCUIElementTypeStaticText");



}

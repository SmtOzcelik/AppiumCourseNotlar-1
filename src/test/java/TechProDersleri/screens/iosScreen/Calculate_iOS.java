package TechProDersleri.screens.iosScreen;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Calculate_iOS {
    public By num1= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"1\"]");
    public By num2= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"2\"]");
    public By num3= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"3\"]");
    public  By num4= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"4\"]");
    public  By num5= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"5\"]");
    public By num6= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"6\"]");
    public  By num7= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"7\"]");
    public By num8= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"8\"]");
    public  By num9= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"9\"]");
    public  By num0= AppiumBy.xpath("//XCUIElementTypeButton[@name=\"0\"]");
    public  By arti= AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"+\"]");
    public  By equals= AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"=\"] ");
    public By result=AppiumBy.xpath("(//XCUIElementTypeStaticText)[2]");

}

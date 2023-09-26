package TechProDersleri.screens.androidScreen;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class ViewsScreen {

    public By viewsTitle= AppiumBy.xpath("//android.widget.TextView[@text='Views']");
    public By dragDropButton=AppiumBy.xpath("//android.widget.TextView[@text='Drag and Drop']");
    public By switchesButton=AppiumBy.xpath("//android.widget.TextView[@text='Switches']");

}

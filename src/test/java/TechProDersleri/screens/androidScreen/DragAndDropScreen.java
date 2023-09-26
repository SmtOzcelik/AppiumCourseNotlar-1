package TechProDersleri.screens.androidScreen;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;



public class DragAndDropScreen {

     public By firstDot= AppiumBy.id("com.touchboarder.android.api.demos:id/drag_dot_1");
    public By secondDot= AppiumBy.id("com.touchboarder.android.api.demos:id/drag_dot_2");
    public By thirdDot= AppiumBy.id("com.touchboarder.android.api.demos:id/drag_dot_3");
    public By hiddenDot=AppiumBy.id("com.touchboarder.android.api.demos:id/drag_dot_hidden");

}

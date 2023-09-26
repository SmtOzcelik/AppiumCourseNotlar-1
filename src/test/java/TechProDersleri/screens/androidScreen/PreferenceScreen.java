package TechProDersleri.screens.androidScreen;


import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;



public class PreferenceScreen {

    public By switchButton= AppiumBy.xpath("//android.widget.TextView[@text='9. Switch']");
    public By preferenceText=AppiumBy.xpath("//android.widget.TextView[@text='Preference']");
    public By preferenceDependenciesbuton=AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']");



}

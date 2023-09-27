package TechProDersleri.tests.Day10_Scrolling;

import TechProDersleri.BasePackage.ApiDemosBaseClass;
import TechProDersleri.MetodStepler.ScreenApiDemos;
import TechProDersleri.MetodStepler.ScreenMain;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Appium21_ScrollingMetodlu extends ApiDemosBaseClass {

    @Test
    public void test() throws InterruptedException {

        //Scrolling test yapma

        ScreenMain.contine_tik_yap();
        ScreenMain.ok_tik_yap();
        ScreenMain.uyari_ok_tik_yap();
        ScreenMain.ana_ekranda_oldugunu_dogrula();
        ScreenApiDemos.API_Demos_tik_yap();
        ScreenApiDemos.API_Demos_sayfasinda_oldugunu_dogrula();
        ScreenApiDemos.Views_tik_yap();

        Dimension dimension=driver.manage().window().getSize();
        int start_x= (int) (dimension.width*0.5);
        int start_y= (int) (dimension.height*0.8);

        int end_x= (int) (dimension.width*0.5);
        int end_y= (int) (dimension.height*0.2);

        TouchAction touchAction=new TouchAction(driver);

        touchAction.press(PointOption.point(start_x,start_y))
                .moveTo(PointOption.point(end_x,end_y))
                .release().perform();
        touchAction.press(PointOption.point(start_x,start_y))
                .moveTo(PointOption.point(end_x,end_y))
                .release().perform();


        //Switches tik yap
        //ReusableMethods.tapOnElementWithText("Switches"); bu metodlu hali buluyor tik yapiyor

        WebElement switchesButon= driver.findElement(By.xpath("//android.widget.TextView[@text='Switches']"));
        Boolean arama;
        do {
            arama=switchesButon.isDisplayed();
            if (arama==true){

            }
        }while (arama);

    }
}

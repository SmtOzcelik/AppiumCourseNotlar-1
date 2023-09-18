package Apponte.tests;

import Apponte.pages.Apponte;
import Apponte.utilities.ApponteBeforeAfterTest;
import Apponte.utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login extends ApponteBeforeAfterTest {
    Apponte apponte=new Apponte();

    @Test
    public void loginTest(){
        waitt(5);
        WebElement kurumsalButon=driver.findElement(apponte.kurumsalElement);
        kurumsalButon.click();
        waitt(5);
        WebElement girisYapButon=driver.findElement(apponte.girisYapElement);
        girisYapButon.click();
        waitt(5);
        WebElement tefonBox=driver.findElement(apponte.telefonBoxElement);
        driver.getKeyboard().pressKey("5456574043");
        waitt(5);
        WebElement kodGonderButon=driver.findElement(apponte.kodGonderElement);
        kodGonderButon.click();
        waitt(5);



    }
}

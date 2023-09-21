package Apponte.tests;

import Apponte.pages.Apponte;
import Apponte.utilities.ApponteBeforeAfterTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Login extends ApponteBeforeAfterTest {
    Apponte apponte=new Apponte();

    @Test
    public void loginTest(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(apponte.kurumsalElement)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(apponte.girisYapElement)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(apponte.telefonBoxElement)).sendKeys("5555555555");

        wait.until(ExpectedConditions.visibilityOfElementLocated(apponte.kodGonderElement)).click();




    }
}

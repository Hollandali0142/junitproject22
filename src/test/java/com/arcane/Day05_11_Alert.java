package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_11_Alert {

    /*
    Go to https://the-internet.herokuapp.com/javascript_alerts
    setUp method olustur
    3 test methodu olustur:
    acceptAlert() => birinci alert'e tikla, Text'in “I am a JS Alert” oldugunu verify et ve OK'ye tikla , sonra “You successfully clicked an alert” text verify et
    dismissAlert()=> ikinci alert'e tikla,  Text'in "I am a JS Confirm” oldugunu verify et, cancel'i tikla, sonra “You clicked: Cancel” verify et
    sendKeysAlert()=> ucuncu alert'e tikla,  Text'in“I am a JS prompt” oldugunu verify et, “Hello Word” Text'i yaz, OK'ye tikla, and “You entered: Hello Word” Text'ini verify et
 */

    WebDriver driver;
    @Before

    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @Test
    public void acceptAlert() throws InterruptedException {
        //   birinci alert'e tikla,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        //   Text'in “I am a JS Alert” oldugunu verify et
        String expected = "I am a JS Alert";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expected,actualText);
        //   ve OK'ye tikla ,
        driver.switchTo().alert().accept();
        //   sonra “You successfully clicked an alert” textinin verify et

        String resull=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",resull);
        System.out.println(driver.findElement(By.id("result")).getText());




    }
        @Test
        public void dismissAllert(){
        //ikinci alert'e tikla


        //Text'in "I am a JS Confirm” oldugunu verify et



        //cancel'i tikla, sonra “You clicked: Cancel” verify et


        }
}

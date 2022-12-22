package com.arcane;

import com.github.javafaker.Faker;
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
    Faker faker=new Faker();
    @Before

    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        //   birinci alert'e tikla,

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();


        //   Text'in “I am a JS Alert” oldugunu verify et

        driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert",driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //   ve OK'ye tikla ,
        driver.switchTo().alert().accept();

        //   sonra “You successfully clicked an alert” textinin verify et

             String result= driver.findElement(By.id("result")).getText();

            Assert.assertEquals("You successfully clicked an alert",result);
            System.out.println(driver.findElement(By.id("result")).getText());





    }
        @Test
        public void dismissAllert(){
        //ikinci alert'e tikla

            driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();


        //Text'in "I am a JS Confirm” oldugunu verify et

            driver.switchTo().alert().getText();

            Assert.assertEquals("I am a JS Confirm",driver.switchTo().alert().getText());


        //cancel'i tikla,

            driver.switchTo().alert().dismiss();
        //sonra “You clicked: Cancel” verify et

            driver.findElement(By.id("result")).getText();

            Assert.assertEquals("You clicked: Cancel", driver.findElement(By.id("result")).getText());


        }

        @Test
    public void sendKeysAlert() throws InterruptedException {
            //    ucuncu alert'e tikl
           driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();


            //    Text'in“I am a JS prompt” oldugunu verify et,
            driver.switchTo().alert().getText();
            Assert.assertEquals("I am a JS prompt",driver.switchTo().alert().getText());



            //    “Hello Word” Text'i yaz,
            Thread.sleep(3000);
         driver.switchTo().alert().sendKeys("Hello Word");

            //    OK'ye tikla,

            driver.switchTo().alert().accept();

            Thread.sleep(3000);

            //    and “You entered: Hello Word” Text'ini verify et

               driver.findElement(By.xpath("//p[@id='result']")).getText();

               Assert.assertEquals("You entered: Hello Word",driver.findElement(By.xpath("//p[@id='result']")).getText());


        }
}

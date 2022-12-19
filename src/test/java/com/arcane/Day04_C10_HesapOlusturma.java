package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day04_C10_HesapOlusturma {

    /*
    Zorunlu tum alanlari doldurun ve Hesap olusturmanin basarili oldugunu verify edin
1. Create a class HesapOlusturma

2. Go to https://www.automationexercise.com/
3. Signup/Login link'ine click edin
4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
5. Text'i Verify et : ENTER ACCOUNT INFORMATION
6. Text'i Verify et : ADDRESS INFORMATION
7. Text'i Verify et : Title
8. title'i secin
9. Name girin (var olani degistir)
10. Password girin
11. Date of Birth (dogum tarihi) girin
12. Sign up for our newsletter! click edin
13. Receive special offers from our partners! click edin
14. first name girin
15. last name girin
16. company girin
17. Address girin
18. Country secin
19. State girin
20. City girin
21. ZipCode girin
22. mobile phone girin
23. Create Account'u Click edin
24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
     */

        WebDriver driver;
        Faker faker=new Faker();
    @Before

    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @Test

    public void hesapolusturma(){

// 2. Go to https://www.automationexercise.com/

        driver.get("https://www.automationexercise.com/");

// 3. Signup/Login link'ine click edin
       driver.findElement(By.xpath("//a[@href='/login']")).click();

// 4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

// 5. Text'i Verify et : ENTER ACCOUNT INFORMATION

     Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());

// 6. Text'i Verify et : ADDRESS INFORMATION

       Assert.assertTrue(driver.findElement(By.xpath("(//h2)[2]")).isDisplayed());

// 7. Text'i Verify et : Title
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Title']")).isDisplayed());

// 8. title'i secin

     WebElement male= driver.findElement(By.xpath("//input[@id='id_gender1']"));
        if (!male.isSelected()){

            male.click();
        }

// 9. Name girin (var olani degistir)

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(faker.name().firstName());

//10. Password girin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(faker.internet().password());
//11. Date of Birth (dogum tarihi) girin
        //day
       WebElement day=driver.findElement(By.xpath("//select[@id='days']"));
        Select dayDrop=new Select(day);
            dayDrop.selectByIndex(5);
        //mand
       WebElement mand=driver.findElement(By.xpath("//select[@id='months']"));
       Select mandDrop=new Select(mand);
       mandDrop.selectByValue("5");
        //year
        WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
        Select yearDrop=new Select(year);
        yearDrop.selectByIndex(5);
//12. Sign up for our newsletter! click edin
       WebElement newsletter= driver.findElement(By.xpath("//*[@for='newsletter']"));

        if(!newsletter.isSelected()){

            newsletter.click();
        }

//13. Receive special offers from our partners! click edin
      WebElement  Receive= driver.findElement(By.xpath("//*[@for='optin']"));
        if (!Receive.isSelected()){
            Receive.click();
        }

//14. first name girin
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());

//15. last name girin
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());

//16. company girin
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());

//17. Address girin

        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());

//18. Country secin

        WebElement country=driver.findElement(By.xpath("//select[@id='country']"));
            Select countryDrop=new Select(country);
            countryDrop.selectByValue("India");


//19. State girin

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());

//20. City girin

        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().state());


//21. ZipCode girin

        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());

//22. mobile phone girin

        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().phoneNumber());


//23. Create Account'u Click edin

        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();

//24. Ardindan ACCOUNT CREATED!'un sayfada bulundugunuzu verifey edin

       Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed());


    }

        @After
         public void finsh(){
        driver.close();

        }





}




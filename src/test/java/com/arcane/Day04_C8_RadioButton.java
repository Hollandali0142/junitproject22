package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day04_C8_RadioButton {

    /*
    Test method olusturun ve asagidaki task'i tamamlayin.
    https://www.facebook.com/ adresine gidin
    Create an Account button'una click edin
    Radio button'larin elementlerini locate edin
    Ardindan eger cinsiyet secili degilse radio button'a click ederek secin
    Sing Up buttonuna click edip hesap olusturun
    */

    WebDriver driver;
    Faker faker=new Faker();

    @Before

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    @Test
    public void radioButton() throws InterruptedException {

//        https://www.facebook.com/ adresine gidin

          driver.get("https://www.facebook.com/");

 //bazen cerezleri kabul et butonu cikabilir.asagidaki sekilde yapariz

        driver.findElement(By.xpath("//button[@title='Temel ve isteğe bağlı çerezlere izin ver']")).click();


    // Create an Account button'una click edin

        Thread.sleep(3000);

        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

        //        Radio button'larin elementlerini locate edin
        //zorunlu alanlari girmek lazim
        //first name
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());

        //lastname
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());

        //email adresi
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());

        //email dogrulama isterse
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(faker.internet().emailAddress());

        //password

        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());
        Thread.sleep(2000);
            //dogum tarihini ekleyin
            //1. adim gun
       WebElement gun= driver.findElement(By.xpath("//select[@id='day']"));
        Select gunDropdown=new Select(gun);
        gunDropdown.selectByValue("21");
        Thread.sleep(2000);
        //2. adim ay

        WebElement ay= driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select ayDropdown=new Select(ay);
        ayDropdown.selectByVisibleText("May");
        Thread.sleep(2000);
        //3. adim yil ekle
        WebElement yil= driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select yilDropdown=new Select(yil);
            yilDropdown.selectByVisibleText("1998");
        Thread.sleep(2000);
            // Ardindan eger cinsiyet secili degilse radio button'a click ederek secin

        WebElement  maleSecenek = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        WebElement  FemaleSecenek = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));

        //Ardindan eger cinsiyet secili degilse radio button'a click ederek secin

            if(!maleSecenek.isSelected()){

                maleSecenek.click();
            }

            // Sing Up buttonuna click edip hesap olusturun

            driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }




}

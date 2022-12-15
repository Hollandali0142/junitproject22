package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_C5_GoogleArama {

        /*
    Yeni class olustur : GoogleAramaTest
    Test method'u  olustur ve asagidaki task'i tamamlayin.
    Kullanici https://www.google.com gider
    “porselen caydanlik” aransin
    Bununla baglantili Google'da kac tane sonuc gosteriliyor test edin
    */

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        /*
        implicitlyWait ekle

        30 saniye kdar bekle eger ihtiyac duyarsan ===bu javadaki Thread.sleep() methodu gibi degildir
        --Eger driver 1 saniyeye ihtiyac duyarsa .sadece 1 saniye bekler implicitlyWait ==>dinamik bir beklemedir
        --neden beklemeye ihtiyac duyulur
            >Internet yavas olabilir
            >Bilgisayarimizin ozelliklerinden dolayi yavas olabilir
            >Sayfadaki resim, video ve iframe lerden dolayi sayfa yavas olabilir
         */
    }

    @Test

    public void caydanlikBul(){

        // Kullanici https://www.google.com gider
        driver.get("https://www.google.com");

        //“porselen caydanlik” aransin

        driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();

       driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("porselen caydanlik"+Keys.ENTER);

        //Bununla baglantili Google'da kac tane sonuc gosteriliyor test edin

      // String sonucsayisi=driver.findElement(By.xpath("//div[@id='result-stats']")).getText().substring(9,16);

        String[] sonucsayisi=driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");

        System.out.println(sonucsayisi[1]);

    }


       @After
        public void tearDown(){
       driver.close();

        }



}

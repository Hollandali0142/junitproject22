package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_C1_FirstMavenClass {

    public static void main(String[] args) {

       // System.setProperty("driver Type", "Drive Path i"=artik kullanmayacagiz

        //chrome driver'i set et
       WebDriverManager.chromedriver().setup();

        //birtane driver objesi olustur
   WebDriver driver=new ChromeDriver();


        //ekrani kapla
   driver.manage().window().maximize();

        //amazona git
    driver.get("https://www.amazon.com");

        //browser kapat
         driver.close();



    }
}

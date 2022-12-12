package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_C4_xpath {

    // email adresi xpath ile locate et ==> "https://www.testyou.in/Login.aspx"
    // password'u xpath ile locate et
    // Login'i xpath ile locate et
    // log out'u xpath ile locate et

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void xpathTest(){

    }

    @After
    public void tearDown(){
//        driver.close();

    }

}

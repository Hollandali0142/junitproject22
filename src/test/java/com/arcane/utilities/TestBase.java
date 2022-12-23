package com.arcane.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    //TetBase classini abstract yaptik cunki bu classtan object(nesne) olustumayacagiz

    //bu siniftaki object ve methodlara exteds ile erisim saglariz

    protected WebDriver driver;
    @Before

    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    // @After
    //    public void tearDown(){
        //close method
     //    driver.close();

   // }

}

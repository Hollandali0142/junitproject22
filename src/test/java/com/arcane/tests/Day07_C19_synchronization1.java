package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day07_C19_synchronization1 extends TestBase {

    /*
    method olustur: synchronization1
    1- https://the-internet.herokuapp.com/dynamic_controls adresine git
    2- remove button'una tiklayin
    3- Mesajin “It's gone!” oldugunu verify edin
    4- Add button'una tiklayin
    5- Mesajin “It's back!” oldugunu verify edin
    */

        @Test
    public void synchronization1(){
        // 1- https://the-internet.herokuapp.com/dynamic_controls adresine git
           driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
       // 2- remove button'una tiklayin
            driver.findElement(By.xpath("//button[.='Remove']")).click();

       // 3- Mesajin “It's gone!” oldugunu verify edin

            //1.yol
             WebElement goneElement= driver.findElement(By.id("message"));

           Assert.assertTrue(goneElement.getText().equals("It's gone!"));

            //2.yol
            /*Explicitly wait ekle
            1.WebDriverWait object olustur
                WebDriverWait wait=new WebDriverWait(driver,10)
             2.wait object kullanarak element yuklenmesi icin bekleme ekle

             */
            WebDriverWait wait=new WebDriverWait(driver,10);
            //Explicitly wait asagidaki islemleri yapar
            //a-driver.findElement(By.id("message")) elementi bulmak icin 10 saniye kadar bekler
            //b-Eger elementi 10 saniyede bulursa WebElement olarak doner
            //c-Eger elementi 10 saniyede bulmaz ise bu asma basarisiz olur

       WebElement  mesajBekleme=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            Assert.assertTrue(goneElement.getText().equals("It's gone!"));

            // 4- Add button'una tiklayin
            driver.findElement(By.xpath("//button[.='Add']")).click();
            WebElement  Bekleme=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));


            // 5- Mesajin “It's back!” oldugunu verify edin

          WebElement backElemet = driver.findElement(By.id("message"));
            Assert.assertTrue(backElemet.getText().equals("It's back!"));

        }
}

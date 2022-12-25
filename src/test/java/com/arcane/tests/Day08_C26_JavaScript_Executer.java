package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test ;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day08_C26_JavaScript_Executer extends TestBase {

    /*
  Javascript Executer ile bazi brower eventlerini otomate icin kullaniriz
    -scroll up/down/right/left==page up/down/right ==arrow up/down
    -elemente kadar kaydir
    -click
    -alert
    -renk degistirebiliriz

    note:scrollIntoView() istedigimiz elemente kadar asagi/yukari yada saga/sola kaydirabilir


    */

    /*
    Kullanici aplicasyonun Url ("http://www.carettahotel.com/"); (websayfasi)'ine gider
    Sayfada "Have a Questions?" text'ini verify et


     */


   @Test
   public void scrollIntoView() throws InterruptedException {
      driver.get("http://www.carettahotel.com/");
      driver.findElement(By.id("details-button")).click();

      driver.findElement(By.id("proceed-link")).click();

      //elementi asagiya kaydir

     WebElement question= driver.findElement(By.xpath("//*[.='Have a Questions?']"));

  //    Assert.assertTrue(question.isDisplayed());
      Thread.sleep(3000);
      JavascriptExecutor je=(JavascriptExecutor)driver;
      je.executeScript("arguments[0].scrollIntoView(true);",question);
      Thread.sleep(3000);

      Assert.assertEquals(question.getText(),"Have a Questions?");

   }

}

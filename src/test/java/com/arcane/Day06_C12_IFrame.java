package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day06_C12_IFrame {

    /*
    method olustur: iframeTest
    https://the-internet.herokuapp.com/iframe adresine git
    Bolded/kalin yazilan text'in “Editor” kelimesii contain/icerdigini verify et
    text box'i locate et
    text box icindeki text'i sil
    “This text box is inside the iframe” yaz
    Elemental Selenium text'in sayfada gosterildigini/displayed verify et
    */

    WebDriver driver;
    @Before

    public void setUP() {
        //method olustur: iframeTest
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // https://the-internet.herokuapp.com/iframe adresine git
        driver.get("https://the-internet.herokuapp.com/iframe");

    }
        @Test
    public void irrameTest(){
          // 1 Bolded/kalin yazilan text'in “Editor” kelimesii contain/icerdigini verify et

        String boldedTekst=driver.findElement(By.xpath("//h3")).getText();
           Assert.assertTrue(boldedTekst.contains("Editor"));
            System.out.println(boldedTekst);

            //2 text box'i locate et
                //1.yol iframe gecis icin index kullanma==>indexler o dan baslar

                // driver.switchTo().frame(1);

                //2.yol iframe gecis icin id/name value degerini kullaniriz
                //eger iframe id'ye sahipse bu durumda id value/degerini iletiyoruz.
           // driver.switchTo().frame("mce_0_ifr");

               //3.yol iframe gecis icin WebElement kullanilabilir

            WebElement iframeElement=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
            driver.switchTo().frame(iframeElement);

            //3 text box icindeki text'i sil

            WebElement textBox=driver.findElement(By.xpath("//p"));
            textBox.clear();

            //4 “This text box is inside the iframe” yaz
            textBox.sendKeys("This text box is inside the iframe");

            //5 Elemental Selenium text'in sayfada gosterildigini/displayed verify et
                //Elementel Selenium IFrame disindadir
                //parent frame gecis yapmak lazim
            driver.switchTo().parentFrame();
           WebElement elementSelenium= driver.findElement(By.linkText("Elemental Selenium"));
            Assert.assertTrue(elementSelenium.isDisplayed());

        }

        @After
      public void tearDown(){
        //close methodu
        driver.close();


        }



}

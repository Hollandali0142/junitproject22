package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alistirma {

    /*  Bir class olustur : LocatorsGiris
    Main method olustur ve asagidaki gorevi (task) yap.
    Kullanici "https://www.testyou.in/Login.aspx" gider
    username textbox, password textbox, and signin button icin locator bul
    Kullanici adi and password'i gir ve sign in button click et
    Username : aykut.arcanedata@gmail.com
    Password : Aykut123!
    Kullanici adini verify et (USE getText() method to get the text from the page)
    Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
    Sayfada bulunan toplam link sayisini bul
    Sayfadan log out yapiniz
    Logged out basarili oldugunu verify edin

 */

    WebDriver chorome;

    @Before

    public void once(){

        WebDriverManager.chromedriver().setup();
        chorome=new ChromeDriver();
        chorome.manage().window().maximize();

    }


   @Test

    public void alistirma(){

        chorome.get( "https://www.testyou.in/Login.aspx");

        chorome.findElement(By.xpath("//input[@name='ctl00$CPHContainer$txtUserLogin']")).sendKeys("aykut.arcanedata@gmail.com");
        chorome.findElement(By.xpath("//input[@id='ctl00_CPHContainer_txtPassword']")).sendKeys("Aykut123!");
        chorome.findElement(By.xpath("//input[@name='ctl00$CPHContainer$btnLoginn']")).click();
        chorome.findElement(By.xpath("//a[@class='signout']")).click();
   }

    @After

    public void tearDown(){

        chorome.close();

    }

}

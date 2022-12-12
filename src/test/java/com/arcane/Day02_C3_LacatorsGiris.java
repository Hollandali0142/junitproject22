package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_C3_LacatorsGiris {

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
    WebDriver chrome;

    @Before
        public void setup(){

        WebDriverManager.chromedriver().setup();
        chrome=new ChromeDriver();
        chrome.manage().window().maximize();

        }

    @Test
    public void locatorGiris(){

       chrome.get ("https://www.testyou.in/Login.aspx");

       //kullanici adini locate ettik ve kullanici adini gonderdik

      //WebElement emailBox = chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin"));
      //  emailBox.sendKeys("aykut.arcanedata@gmail.com");
        chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).
                sendKeys("aykut.arcanedata@gmail.com");

      //password icin yapalim

      chrome.findElement(By.name("ctl00$CPHContainer$txtPassword")).
              sendKeys("Aykut123!");

      //sing in buttonu locate et ve tikla (click yap)

        chrome.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();

        //kullanici adini verify et(dogrula)

        WebElement kullaniciAdi=chrome.findElement(By.id("ctl00_headerTopStudent_username"));

        //getText() web elementin kendisini string olarak dondurur.
        String kullaniciAditext= kullaniciAdi.getText();
        System.out.println(kullaniciAditext);

        String expectedKullaniciAdi="Aykutsaglam ,";
        Assert.assertEquals(expectedKullaniciAdi,kullaniciAditext );

       // Home  sekmelerinin sayfada gosterildigini dogrula/verify et

        WebElement homeElement= chrome.findElement(By.linkText("Home"));

       //WebElement homeElement1=chrome.findElement(By.partialLinkText("Hom"));
       /*
       LisnkText() ile partiallinkText() arasindaki farklar
       -linkText() kullaniyorsak mutlaka text veya metnin tamami bosluk ve noktalama isaretleri yuazmak lazim
       -partialLinkText() metnin taamini yazabildigimiz gibi bir kismini yazabilirsiniz
       -LinkText() daha guvenlidir, cunku butun metni eksiksiz ekledigimizde yanlis yapma olasiligi azalir
        */

        Assert.assertTrue(homeElement.isDisplayed());
        //isDisplayed() bir elementin sayfada bulunup bulunmadigini gosterir
        //Return type boolean=> element bulunursa true, bulunmaz ise false

       //log out sekmelerinin sayfada gosterildigini dogrula/verify et


      WebElement logoutElement = chrome.findElement(By.className("signout"));
        Assert.assertTrue(logoutElement.isDisplayed());

        //sayfada bulunan toplam link sayisini bul
        // linkler "a" tag ile olusturulur "a" lri bulursam butun linkleri bulmus olurum

       List<WebElement> tumLinkler= chrome.findElements(By.tagName("a"));
        int linkSize=tumLinkler.size();
        System.out.println("Tum linklerin sayisi"+ linkSize);

        //Sayfadan log out yapiniz
        chrome.findElement(By.className("signout")).click();

        //Logged out yapildigini verfy et yani dogrula

       Boolean loogeOut= chrome.getCurrentUrl().equals("http://testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx%3faction%3dlogout&action=logout");

        Assert.assertTrue(loogeOut);
    }

    @After
    public void tearDown(){

        chrome.close();
    }

}
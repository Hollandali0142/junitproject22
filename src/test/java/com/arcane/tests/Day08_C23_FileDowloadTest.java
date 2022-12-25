package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day08_C23_FileDowloadTest extends TestBase {


        /*
    FileDownloadTest() olustur
    1- https://the-internet.herokuapp.com/download adresine git
    2- webdriverIO.png download et
    3- Dosyanin download edildigini verify et
     */

    @Test
    public void FileDownloadTest() throws InterruptedException {

//        1- https://the-internet.herokuapp.com/download adresine git
        driver.get("https://the-internet.herokuapp.com/download");


//        2- webdriverIO.png download et
        driver.findElement(By.linkText("webdriverIO.png")).click();
            //DownLoad Mutlaka Har wait eklenmeli cunki dosyanin indirilmesi zaman alabilir
            //implicitly ve explicitly wait bekleme sorununu cozmez dowload window(bilgisayar) aplikasyonudur
            //selenium ile halledilemez
        Thread.sleep(3000);

//        3- Dosyanin download edildigini verify et

            String homePath=System.getProperty("user.home");//C:\Users\Acer\Downloads\webdriverIO.png
         String fotoPath =  homePath+"\\Downloads\\webdriverIO.png";
        boolean dowloadEttimi= Files.exists(Paths.get(fotoPath));
        Assert.assertTrue(dowloadEttimi);


    }


}

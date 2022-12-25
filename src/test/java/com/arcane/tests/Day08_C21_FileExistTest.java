package com.arcane.tests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day08_C21_FileExistTest {

    /*
    Method: dosyaVarmi
    1- Masaustundeki bir dosyayi secin
    2- Bu dosyanin bilgisayarinizda bulunup bulunmadigini verify edin
    */

    @Test
    public void  dosyaVarmi(){

       String homePath=System.getProperty(("user.home"));

        System.out.println(homePath);//C:\Users\Acer
        //"C:\Users\Acer\Desktop\images.jpg"

       String cicekPath= homePath+"\\Desktop\\images.jpg";

        System.out.println(cicekPath);
       Boolean Varmi= Files.exists(Paths.get(cicekPath));

        Assert.assertTrue(Varmi);

    }


}

package com.arcane;

import org.junit.*;
import org.junit.runner.notification.RunListener;

public class Day01_C2_FirstJUnitClass {

    //@Test : test case olustur. Bu test cases olusturma ve kosturmaya yardimci olur
    // @Before : Runs before each @Test annotation. tekrarlanan pre condition icin kullanilir
    // @After : Runs after each @Test annotation. tekrarlanan post conditions icin kullanilir
    // @AfterClass, @BeforeClass
    // @Ignore: test case atlatmak icin kullanilir

    @Before
    public void setup() {
        System.out.println("Bu bir stup methodudur");

    }

    @Test
    public void test01() {

        System.out.println("Test case 1");
    }

    @Ignore //kendisinden sonrakini ilk testi calistirmaz
    @Test
    public void test02() {
        System.out.println("test case 2");
    }

    @Test
    public void test03() {

        System.out.println("test case 3");
    }

    @After
//tearDown methodudur yani kapatma .test metodlari calistiktan sonra baska bir methodu calistirmak istersek kullaniriz
    public void tearDown() {

        System.out.println("Bu bir tearDown methodudur");
    }
    /*
    junit Assertion

        Expected=actual , ise assertion yapilir
     */

    @Test
    public void assertion() {

        //1.Assert.assertTrue
        Assert.assertTrue(3 == 3);//test gecer

        //2.Assert.assertFalse()
         Assert.assertFalse(3==4);//test gecer

        Assert.assertFalse("Selenium".contains("a"));//test basarili

        //3 .sssert.asserEquals()
         Assert.assertEquals("Java","java");//test basarili
          Assert.assertEquals("java","javascript");//test basarisizxc

         }

    }

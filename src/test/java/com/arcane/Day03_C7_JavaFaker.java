package com.arcane;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day03_C7_JavaFaker {

    //cogunlukla testler icin fake data kullaniriz
    //Javafaker de face data kullanmak icin olusturulmustur
    //java fake dependency pox.xml eklemistik

    @Test
    public void fakerTest(){
        //1. Faker data type de object olustur

        Faker faker=new Faker();

        //2. Ardindan fake data kullanabiliriz: firstname, lastname, addrees, city, state, country


       String fname= faker.name().firstName();

        System.out.println(fname);

        String lname=faker.name().lastName();
        System.out.println(lname);

        String fullname=faker.name().fullName();
        System.out.println(fullname);

        //title
        System.out.println(faker.name().title());

        //city
        System.out.println(faker.address().city());

        //state
        System.out.println(faker.address().state());

        //phone number
        System.out.println(faker.phoneNumber().cellPhone());

        //zipcode/post code

        System.out.println(faker.address().zipCode());

        // rastgele email

        System.out.println(faker.internet().emailAddress());

        //rastgele rakam
        System.out.println(faker.number().digits(12));

    }




}

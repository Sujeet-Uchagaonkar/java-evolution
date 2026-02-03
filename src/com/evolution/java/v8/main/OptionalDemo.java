package com.evolution.java.v8.main;

import com.evolution.java.v8.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {


    public static void main(String[] args) {

        // Creating optional
        Optional<String> optional = Optional.ofNullable("java");


        System.out.println("Chceking if optional has value with isPresent() method");
        System.out.println("isPresent value : "+optional.isPresent());


        // empty optional
        Optional<String> emptyOptional = Optional.ofNullable(null);
        System.out.println("isPresent value for empty optional : "+emptyOptional.isPresent());




    }

}

package org.example.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author neeraj on 17/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _Lambdas {

    public static void main(String[] args) {
        Function<String, String> upperCaseName =
                name -> name.toUpperCase();


        BiFunction<String, Integer, String> upperCaseNameAndPrint = (name, age) -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseNameAndPrint.apply("Alex", 20));
    }
}

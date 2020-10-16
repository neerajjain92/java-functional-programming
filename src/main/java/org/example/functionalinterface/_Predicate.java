package org.example.functionalinterface;

import java.util.function.Predicate;

/**
 * @author neeraj on 16/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without Predicate : ");
        System.out.println(isPhoneNumberValid("8686753667"));
        System.out.println(isPhoneNumberValid("941316242"));

        System.out.println("With Predicate : ");
        System.out.println(isPhoneNumberValidPredicate.test("8686753667"));
        System.out.println(isPhoneNumberValidPredicate.test("941316242"));

        // Combining Predicate
        System.out.println("Combining Predicates : ");
        System.out.println("Is Phone Number Valid and contains digit 3 ::=> " +
                isPhoneNumberValidPredicate.and(containsNumber).test("8686753667"));
        System.out.println("Is Phone Number Valid and contains digit 3 ::=> " +
                isPhoneNumberValidPredicate.and(containsNumber).test("8686757667"));

        System.out.println("Is Phone Number Valid or contains digit 3 ::=> " +
                isPhoneNumberValidPredicate.or(containsNumber).test("6302194843"));

        // Bi Predicates
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.length() == 10 &&
                    (phoneNumber.startsWith("9")
                            || phoneNumber.startsWith("8")
                            || phoneNumber.startsWith("7"));

    static Predicate<String> containsNumber = phoneNumber ->
            phoneNumber.contains("3");

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.length() == 10 &&
                (phoneNumber.startsWith("9")
                        || phoneNumber.startsWith("8")
                        || phoneNumber.startsWith("7"));
    }
}

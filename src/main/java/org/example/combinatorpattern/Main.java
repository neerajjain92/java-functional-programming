package org.example.combinatorpattern;

import org.example.combinatorpattern.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static org.example.combinatorpattern.CustomerRegistrationValidator.isAdult;
import static org.example.combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;

/**
 * @author neeraj on 17/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "9929675532",
                LocalDate.of(2018, 1, 1)
        );

        CustomerValidatorService service = new CustomerValidatorService();

        System.out.println("Is Customer Valid ? " + service.isValid(customer));

        // We can store customer in the db since it's valid

        // Using Combinator Pattern
        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalAccessException(result.name());
        }
    }
}

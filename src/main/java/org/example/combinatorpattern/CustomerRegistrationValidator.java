package org.example.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static org.example.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

/**
 * Example of Combinator pattern
 *
 * @author neeraj on 17/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public interface CustomerRegistrationValidator
        extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer ->
                customer.getEmail().contains("@")
                        ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("9") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 18
                        ? SUCCESS : IS_NOT_AN_ADULT;
    }

    /**
     * THis is the combinator magic.
     */
    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result .equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}

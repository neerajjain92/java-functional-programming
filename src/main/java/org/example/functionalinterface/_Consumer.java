package org.example.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author neeraj on 16/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _Consumer {

    public static void main(String[] args) {

        // Normal Java Function
        Customer customer = new Customer("Bill Gates", "014-x233c");
        greetCustomer(customer);

        // Now performing the same functionality with Consumer
        // Note in Function we were applying whereas here we are accept.
        // Consumer Functional Interface.
        greetCustomerConsumer.accept(customer);

        greetCustomerBiConsumer.accept(customer, true);
        greetCustomerBiConsumer.accept(customer, false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.name + ", thanks for registering phone number "
                    + customer.phoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.name + ", thanks for registering phone number "
                    + (showPhoneNumber == true ? customer.phoneNumber : "********"));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.name + ", thanks for registering phone number "
                + customer.phoneNumber);
    }

    static class Customer {
        private final String name;
        private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}

package org.example.optional;

import java.util.Optional;

/**
 * @author neeraj on 16/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _Optional {

    public static void main(String[] args) {

        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default Value");

        System.out.println(value);

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending Email to .... " + email),
                        () -> System.out.println("Cannot Send email...")
                );
    }
}

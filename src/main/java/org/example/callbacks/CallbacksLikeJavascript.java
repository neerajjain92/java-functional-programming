package org.example.callbacks;

import java.util.function.Consumer;

/**
 * @author neeraj on 17/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class CallbacksLikeJavascript {

    public static void main(String[] args) {
        hello("John", null,
                value -> System.out.println("Last Name not provided for "+ value));
        hello("John", "Montana",
                value -> System.out.println("Last Name not provided for "+ value));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    // In Chrome Browser try this Javascript
//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if(lastName) {
//            console.log(lastName);
//        } else {
//            callback();
//        }
//    }

//    hello("Neeraj", null, () => console.log("LastName not provided"));
}

package org.example.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author neeraj on 16/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionURLSupplier.get());
        System.out.println(getAllDBConnURLs.get());
    }

    static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:5432";

    static Supplier<List<String>> getAllDBConnURLs = () -> List.of(
            "jdbc://localhost:5432",
            "jdbc://localhost:5430");

    static String getDBConnectionURL() {
        return "jdbc://localhost:5432";
    }
}

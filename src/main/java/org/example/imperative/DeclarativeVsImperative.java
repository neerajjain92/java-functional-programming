package org.example.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.example.imperative.DeclarativeVsImperative.Gender.FEMALE;
import static org.example.imperative.DeclarativeVsImperative.Gender.MALE;


/**
 * @author neeraj on 14/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class DeclarativeVsImperative {

    enum Gender {
        MALE, FEMALE
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        System.out.println(" Imperative Approach");
        // Imperative approach.
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        System.out.println(females);

        System.out.println(" Declarative Approach");
        // Declarative Approach
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}

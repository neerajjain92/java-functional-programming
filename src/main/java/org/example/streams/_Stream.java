package org.example.streams;


import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.example.streams._Stream.Gender.FEMALE;
import static org.example.streams._Stream.Gender.MALE;

/**
 * @author neeraj on 16/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        // Using Map
        System.out.println("Transforming using Map");
        Function<Person, Gender> personGenderFunction = person -> person.gender;
        final Collector<Gender, ?, Set<Gender>> genderSetCollector = Collectors.toSet();
        final Consumer<Gender> action = x -> System.out.println(x);

        people.stream()
                .map(personGenderFunction)
                .collect(genderSetCollector)
                .forEach(action);

        System.out.println("List only contains females ? " + people.stream()
                .allMatch(person -> FEMALE.equals(person.gender)));
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

    enum Gender {
        MALE, FEMALE
    }
}

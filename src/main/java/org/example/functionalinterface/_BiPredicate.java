package org.example.functionalinterface;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * @author neeraj on 16/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _BiPredicate {

    public static void main(String[] args) {
        List<Domain> domains = List.of(
                new Domain("google.com", 1),
                new Domain("i-am-spammer.com", 10),
                new Domain("mkyong.com", 0),
                new Domain("microsoft.com", 2)
        );

        BiPredicate<String, Integer> googleBiPredicate = (domain, score) ->
                domain.equalsIgnoreCase("google.com") || score == 0;

        // if Google or Score == 0;
        System.out.println(filterBadDomain(domains, googleBiPredicate));

        //  if score == 0
        System.out.println(filterBadDomain(domains, (domain, score) -> score == 0));

        // if start with i or score > 5
        List<Domain> result3 = filterBadDomain(domains, (domain, score) -> domain.startsWith("i") && score > 5);
        System.out.println(result3); // i-am-spammer.com

        // chaining with or
        List<Domain> result4 = filterBadDomain(domains, googleBiPredicate.or(
                (domain, x) -> domain.equalsIgnoreCase("microsoft.com"))
        );
        System.out.println(result4); // google.com, mkyong.com, microsoft.com

    }

    public static <T extends Domain> List filterBadDomain(List<T> list, BiPredicate<String, Integer> biPredicate) {
        return list.stream().filter(
                item -> biPredicate.test(item.name, item.score))
                .collect(Collectors.toUnmodifiableList());
    }

    static class Domain {
        String name;
        int score;

        public Domain(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Domain{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}

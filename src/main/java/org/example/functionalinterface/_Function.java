package org.example.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author neeraj on 15/10/20
 * Copyright (c) 2019, java-functional-programming.
 * All rights reserved.
 */
public class _Function {
    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int incrementAndThenMultiply =
                incrementByOneFunction
                        .andThen(multiplyByTenFunction)
                        .apply(4);

        System.out.println(incrementAndThenMultiply);

        System.out.println(incrementBy1AndThenMultiplyBy(1, 10));

        /**
         * BiFunction, takes 2 argument and produces a result
         */
        System.out.println(incrementByOneAndThenMultiplyByFunction.apply(10, 500));

    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction =
            number -> number * 10;


    static BiFunction<Integer, Integer, Integer> incrementByOneAndThenMultiplyByFunction =
            (numberToIncrementBy1, numToMultiplyBy) -> (numberToIncrementBy1 + 1) * numToMultiplyBy;

    static int increment(int number) {
        return number + 1;
    }

    static int incrementBy1AndThenMultiplyBy(int num, int numToMultiplyBy) {
        return (num + 1) * numToMultiplyBy;
    }
}

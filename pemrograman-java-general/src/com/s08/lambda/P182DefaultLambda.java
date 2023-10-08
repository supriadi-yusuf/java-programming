package com.s08.lambda;

// we can find several defined lambda in package java.util.function

import java.util.Random;
import java.util.function.*;

public class P182DefaultLambda {

    public static void consumer() {
        // anynomous class
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };

        // make it lambda
        Consumer<String> simpleConsumer = (String value) -> {
            System.out.println(value);
        };

        // make it simpler lambda
        Consumer<String> simplerConsumer = (value) -> {
            System.out.println(value);
        };

        // make it more simple lambda
        Consumer<String> simpler2Consumer = value -> System.out.println(value);

        // make it simplest with method reference
        Consumer<String> simplestConsumer = System.out::println;
        simplestConsumer.accept("hello 1234");
    }

    public static void function() {

        Function<String, Integer> function = new Function<>() {
            @Override
            public Integer apply(String value) {
                return value.length();
            }
        };

        // make it lambda
        Function<String, Integer> simpleFunction = (String value) -> {
            return value.length();
        };

        // make it simpler lambda
        Function<String, Integer> simplerFunction = (value) -> {
            return value.length();
        };

        // more simple lambda
        Function<String, Integer> simpler2Function = value -> value.length();

        // simplest lambda with method reference (method of input class, in this case input is String)
        Function<String, Integer> simplestFunction = String::length;

        System.out.println(simpleFunction.apply("Supriadi Muhammad Yusuf"));
    }

    public static void supplier() {

        // anynomous class
        Supplier<Integer> supplier = new Supplier<>() {
            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };

        // make it lambda
        Supplier<Integer> simpleSupplier = () -> {
            return new Random().nextInt();
        };

        // make it more simple lambda
        Supplier<Integer> simplerSupplier = () -> new Random().nextInt();

        System.out.println(simplerSupplier.get());

    }

    private static void predicate() {

        // anynomous class
        Predicate<Integer> predicate = new Predicate<>() {
            @Override
            public boolean test(Integer value) {
                return value % 2 == 0;
            }
        };

        // make it lambda
        Predicate<Integer> simplePredicate = (Integer value) -> {
            return value % 2 == 0;
        };

        // make it lambda
        Predicate<Integer> simplerPredicate = (value) -> {
            return value % 2 == 0;
        };

        // make it simpler lambda
        Predicate<Integer> simpler2Predicate = (value) ->  value % 2 == 0;

        // make it simplest
        Predicate<Integer> simplestPredicate = value ->  value % 2 == 0;

        System.out.println(simplestPredicate.test(100));

    }

    private static void unaryOperator() {

        // anynomous class
        UnaryOperator<Integer> unaryOperator = new UnaryOperator<>() {
            @Override
            public Integer apply(Integer value) {
                return value * 10;
            }
        };

        // make it lambda
        UnaryOperator<Integer> simpleUnaryOperator = (Integer value) -> {
            return value * 10;
        };

        // make it simple lambda
        UnaryOperator<Integer> simplerUnaryOperator = (value) -> {
            return value * 10;
        };

        UnaryOperator<Integer> simpler2UnaryOperator = value -> {
            return value * 10;
        };

        UnaryOperator<Integer> simplestUnaryOperator = value -> value * 10;

        System.out.println(simplestUnaryOperator.apply(10));

    }

    public static void main(String[] args) {
        consumer();
        function();
        supplier();
        predicate();
        unaryOperator();
    }
}

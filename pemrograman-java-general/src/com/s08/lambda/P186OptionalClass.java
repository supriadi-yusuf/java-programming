package com.s08.lambda;

import java.util.Optional;

public class P186OptionalClass {
    public static void main(String[] args) {
        sayHelloUpperCase("supriadi");
//        sayHelloUpperCase(null); // problem

        sayHelloUpperCaseOptional("supriadi");
        sayHelloUpperCaseOptional(null);
    }

    public static void sayHelloUpperCase(String name){
        String upperCase = name.toUpperCase();
        System.out.println("Hello " + upperCase);
    }

    public static void sayHelloUpperCaseOptional(String name){
        /*Optional<String> optionalName = Optional.ofNullable(name);
        Optional<String> upperName = optionalName.map(String::toUpperCase);
        upperName.ifPresent(value -> System.out.println("HELLO " + value));*/

        /*Optional.ofNullable(name)
                .map(String::toUpperCase)
                .ifPresent(value -> System.out.println("HELLO " + value));*/

        String helloTo = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("Teman");

        System.out.println("Hello " + helloTo);
    }
}

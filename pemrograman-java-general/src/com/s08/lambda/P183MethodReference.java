package com.s08.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class P183MethodReference {

    public static boolean isLowerCase(String value){
        for (char c : value.toCharArray()){
            if (!Character.isLowerCase(c)){
                return false;
            }
        }
        return true;
    }

    public boolean isUpperCase(String value){
        for (char c : value.toCharArray()){
            if (!Character.isUpperCase(c)){
                return false;
            }
        }
        return true;
    }

    private static void run1() {
        Predicate<String> isLowerCase = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return P183MethodReference.isLowerCase(s);
            }
        };

        Predicate<String> isLowerCase2 = value -> P183MethodReference.isLowerCase(value);
        Predicate<String> isLowerCase3 = P183MethodReference::isLowerCase; // method reference static

        System.out.println(isLowerCase3.test("Supriadi"));
        System.out.println(isLowerCase3.test("supriadi"));
    }

    public static void run2(){
        P183MethodReference app = new P183MethodReference();
        Predicate<String> isUpperCase = app::isUpperCase; // method reference non static

        System.out.println(isUpperCase.test("Supriadi"));
        System.out.println(isUpperCase.test("SUPRIADI"));
    }

    public static void run3(){
        Function<String, String> toUpperCase = new Function<>() {
            @Override
            public String apply(String value) {
                return value.toUpperCase();
            }
        };

        Function<String, String> toUpperCase2 = value -> value.toUpperCase();
        Function<String, String> toUpperCase3 = String::toUpperCase; // method reference parameter type

        System.out.println(toUpperCase3.apply("supriadi"));

    }

    public void run4(){
        Predicate<String> isUpperCase = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return P183MethodReference.this.isUpperCase(s);
            }
        };

        Predicate<String> isUpperCase2 = value -> P183MethodReference.this.isUpperCase(value);
        Predicate<String> isUpperCase3 = P183MethodReference.this::isUpperCase; // method reference non static
        Predicate<String> isUpperCase4 = this::isUpperCase; // method reference non static

        System.out.println(isUpperCase4.test("Supriadi"));
        System.out.println(isUpperCase4.test("SUPRIADI"));
    }

    public static void main(String[] args) {

        run1();
        run2();
        run3();

        P183MethodReference methodReference = new P183MethodReference();
        methodReference.run4();
    }
}

package com.s08.lambda;

public class P181CreateLambda {
    @FunctionalInterface
    public static interface SimpleAction{
        String action(String name); // only 1 function
    }
    public static void main(String[] args) {

        SimpleAction simpleAction = (String name) -> {
            return "Hello " + name;
        };

        SimpleAction simpleAction2 = (name) -> {
            return "Hello " + name;
        };

        SimpleAction simpleAction3 = (String name) -> "Hello " + name;
        SimpleAction simpleAction4 = (name) -> "Hello " + name;
        SimpleAction simpleAction5 = name -> "Hello " + name;

        System.out.println(simpleAction.action("supriadi"));
        System.out.println(simpleAction.action("yusuf"));
        System.out.println(simpleAction3.action("syafeie"));
        System.out.println(simpleAction4.action("muhammad"));
        System.out.println(simpleAction5.action("jakarta"));

    }
}

package com.s08.lambda;

public class P180LambdaIntro {
    @FunctionalInterface
    public static interface SimpleAction{
        String action(); // only 1 function
    }

    public static void main(String[] args) {

        SimpleAction simpleAction = new SimpleAction() {
            @Override
            public String action() {
                return "hello 123";
            }
        };

        System.out.println(simpleAction.action());

        // lambda
        SimpleAction simpleAction2 = () -> {
            return "hello 1234";
        };

        System.out.println(simpleAction2.action());
    }
}

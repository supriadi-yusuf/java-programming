package com.s03.oop;

import java.util.Arrays;

// class StackTraceElement will inform us the exact location where error happen
public class P096StackTraceElement {

    public static void main(String[] args) {

        try {
            simpleError();
//            complexError();
        }catch (Throwable throwable){
             throwable.printStackTrace();
        }

    }

    public static void simpleError(){
        try {
            String[] names = {"endang","toni", "lulou"};

            System.out.println(names[100]);
        }catch (Throwable throwable){
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            System.out.println(stackTrace.length);
            System.out.println(Arrays.toString(stackTrace));
            throw  throwable;
        }
    }

    public static void complexError(){
        try {
            String[] names = {"endang","toni", "lulou"};

            System.out.println(names[100]);
        }catch (Throwable throwable){
            throw new RuntimeException( throwable);
        }
    }

}

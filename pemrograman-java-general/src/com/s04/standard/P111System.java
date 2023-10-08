package com.s04.standard;

// linux : env => display env var in console


import java.util.Map;

public class P111System {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis(); // get current time in milli second
        System.out.println(currentTimeMillis);

        long nanoTime = System.nanoTime(); // get current time in nano second
        System.out.println(nanoTime);

        Map<String, String> getenv = System.getenv(); // get all env
        System.out.println(getenv);

        String path = System.getenv("PATH"); // get env PATH
        System.out.println(path);

        System.gc(); // trigger garbage collector

        System.exit(0); // terminate application. 0 means normal, other means not normal

        System.out.println("hello test 123");


    }
}

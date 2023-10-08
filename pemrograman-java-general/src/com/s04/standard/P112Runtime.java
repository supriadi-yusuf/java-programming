package com.s04.standard;

public class P112Runtime {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        int processors = runtime.availableProcessors();
        System.out.println("available processor : " + processors);

        long freeMemory = runtime.freeMemory();
        System.out.println("Free memory at JVM : " + freeMemory);

        long totalMemory = runtime.totalMemory();
        System.out.println("Total memory at JVM : " + totalMemory);

        long maxMemory = runtime.maxMemory();
        System.out.println("Maximum memory at JVM : " + maxMemory);

        runtime.gc(); // call garbage collector

    }
}

package com.s16.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class P335ThreadLocalRandom {
    private static void p01GenerateRandomValue() throws InterruptedException {
        // Class Random is not thread safe. it is not recommended to generate random number using class Random in thread.
        // To generate random number in thread we can use class ThreadLocalRandom

        System.out.println("\n================= Generate Random ======================");

        final ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    int number = ThreadLocalRandom.current().nextInt(); // generate random random in thread wiht class ThreadLocalRandom
                    Thread.sleep(1_000);
                    System.out.println(number);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    private static void p02GenerateStream() throws InterruptedException {
        System.out.println("\n================= Generate Stream ======================");

        // class ThreadLocalRandom can generate stream
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(()->{
            ThreadLocalRandom.current().ints(100,0,1000)
                    .forEach(System.out::println);
        });

        executorService.awaitTermination(3,TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        p01GenerateRandomValue();
        p02GenerateStream();
    }
}

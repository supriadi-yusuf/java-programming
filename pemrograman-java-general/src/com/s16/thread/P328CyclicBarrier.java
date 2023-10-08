package com.s16.thread;

import java.util.concurrent.*;

public class P328CyclicBarrier {
    public static void main(String[] args) {
        // CyclicBarrier will wait until certain number of thread wait (as determined in constructor)
        // threat only start after the number is reached

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5); // parties : number of thread to wait
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        for (int i = 1; i <= 10; i++) {
            final var task = i;

            executorService.execute(() -> {
                try {
                    System.out.println("task - " + task + " waits");
//                    Thread.sleep(2_000);
                    cyclicBarrier.await(); // wait until 5 thread waiting. 5 is as put in constructor
                    System.out.println("task - " + task + " finish");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

            });
        }

        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

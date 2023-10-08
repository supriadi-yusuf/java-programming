package com.s16.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class P327CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // count down latch is also to manage counter. but counter always go down never rise up
        // method countDown() is to decrease counter
        // method await() is to wait until counter is 0

        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            final var task = i;
            executorService1.execute(() -> {
                try {
                    System.out.println("Start task : " + task);
                    Thread.sleep(2_000);
                    System.out.println("Finish task : " + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown(); // decrease counter
                }
            });
        }

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.execute(()->{
            try {
                countDownLatch.await(); // wait until counter is 0
                System.out.println("Finish all tasks");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService1.awaitTermination(3, TimeUnit.SECONDS);

        executorService1.shutdown();
        executorService2.shutdown();
    }
}

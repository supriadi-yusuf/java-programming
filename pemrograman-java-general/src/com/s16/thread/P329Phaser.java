package com.s16.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class P329Phaser {
    private static void p01PhaserAsCountDownLatch() throws InterruptedException {
        final Phaser phaser = new Phaser();
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(3); // so counter = 3
        phaser.bulkRegister(2); // now counter becomes 3 + 2 = 5

        for (int i = 1; i <= 5; i++) {
            final var task = i;

            executorService.execute(() -> {
                try {
                    System.out.println("start task-" + task);
                    Thread.sleep(1_000);
                    System.out.println("finish task-" + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    phaser.arrive();// decrement counter
                }
            });
        }

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.execute(()->{
            phaser.awaitAdvance(0);
            System.out.println("All task finish");
        });

        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
        executorService2.shutdown();
    }

    private static void p02PhaserAsCyclicBarrier() throws InterruptedException {
        final Phaser phaser = new Phaser();
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(3); // so counter = 3
        phaser.bulkRegister(2); // now counter becomes 3 + 2 = 5

        for (int i = 1; i <= 5; i++) {
            final var task = i;

            executorService.execute(() -> {
                phaser.arriveAndAwaitAdvance();
                System.out.println("task-" + task);
            });
        }

        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
// phaser is like combination of  count down latch and cyclic barrier but it is more flexible
//        p01PhaserAsCountDownLatch();
        p02PhaserAsCyclicBarrier();
    }
}

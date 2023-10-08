package com.s16.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class P326Semaphore {
    public static void main(String[] args) throws InterruptedException {
        // synchronizer : semaphore, count down latch, cyclic barrier, phaser, exchanger.
        // semaphore is to manage counter data.
        // release() method is to decrement the counter.
        // acquire() method is to increment the counter. if some thread tries to increase counter when the counter reaches maximum value,
        // it will cause semaphore wait until another thread decrement the counter.

        Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for (int i=0; i<100; i++){
            final var task = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();// increment counter
                    Thread.sleep(1_000);
                    System.out.println("Finish : " + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();// decrement counter
                }
            });
        }

        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}

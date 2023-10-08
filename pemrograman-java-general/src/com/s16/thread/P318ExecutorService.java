package com.s16.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class P318ExecutorService {
    private static void p01SingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0; i<100; i++){
            final var task = i;
            executorService.execute(()->{
                try {
                    Thread.sleep(1_000L);
                    System.out.println("Thread - " + task + " in : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown(); // wait until all thread are executed then shut then down
    }

    private static void p02FixThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<100; i++){
            final var task = i;
            executorService.execute(()->{
                try {
                    Thread.sleep(1_000L);
                    System.out.println("Thread - " + task + " in : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown(); // wait until all thread are executed then shut then down
    }

    private static void p03CachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<100; i++){
            final var task = i;
            executorService.execute(()->{
                try {
                    Thread.sleep(1_000L);
                    System.out.println("Thread - " + task + " in : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown(); // wait until all thread are executed then shut then down
    }

    public static void main(String[] args) {
//        p01SingleThreadExecutor();
//        p02FixThreadPool();
        p03CachedThreadPool();
    }
}

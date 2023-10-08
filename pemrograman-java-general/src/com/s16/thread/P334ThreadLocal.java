package com.s16.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class P334ThreadLocal {
    private static class UserService {

        public void setUser(String user) {
        }

        public void doAction() {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        // data will be stored into local thread and not be shared to others.

        // this object will stored /get data from current thread
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();

        final Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 50; i++) {
            final var index = i;
            executorService.execute(() -> {
                try {
                    String data = "User-" + index;

                    // store data into current thread
                    threadLocal.set(data);

                    Thread.sleep(1_000 + random.nextInt(3_000));

                    // get data stored by this object from current thread
                    data = threadLocal.get();

                    System.out.println(data + " do action");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdown();

    }
}

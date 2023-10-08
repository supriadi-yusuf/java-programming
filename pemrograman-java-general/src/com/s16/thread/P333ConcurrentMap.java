package com.s16.thread;

import java.util.concurrent.*;

public class P333ConcurrentMap {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for(int i=1; i<=100;i++){
            final Integer index = i;
            executorService.execute(()->{
                try {
                    Thread.sleep(1_000);
                    map.putIfAbsent(index, "data-" + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executorService.execute(()->{
            try {
                countDownLatch.await();
                map.forEach((key,value)-> System.out.println(key + " : " + value));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}

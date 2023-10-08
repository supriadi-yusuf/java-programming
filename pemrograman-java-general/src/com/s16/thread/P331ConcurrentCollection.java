package com.s16.thread;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class P331ConcurrentCollection {
    public static void main(String[] args) throws InterruptedException {
        HashSet<String> hashSet = new HashSet<>();
        final Set<String> synchronizedSet = Collections.synchronizedSet(hashSet);

        final ExecutorService executorService = Executors.newFixedThreadPool(50);

        for (int i = 1; i <= 100; i++) {
            final var task = i;
            executorService.execute(() -> synchronizedSet.add("data-" + task));
        }

        final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(()->{
            for (var val : synchronizedSet) {
                try {
                    Thread.sleep(10);
                    System.out.println(val);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },2,TimeUnit.SECONDS);

        scheduledExecutorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
        scheduledExecutorService.shutdown();
    }
}

package com.s16.thread;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.concurrent.*;

public class P322ScheduledExecutorService {
    private static void p01DelayedJob() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(() -> System.out.println("Hello Scheduled"),
                5, TimeUnit.SECONDS);

        Thread.sleep(1_000);

        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        System.out.println(delay);

        Thread.sleep(4_000);

        scheduledExecutorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
//        p01DelayedJob();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println(LocalDateTime.now()), 5, 2, TimeUnit.SECONDS);

        Thread.sleep(2_000);

        long delay = scheduledFuture.getDelay(TimeUnit.SECONDS);

        System.out.println(delay);

        scheduledExecutorService.awaitTermination(20,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

    }
}

package com.s16.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class P330Exchanger {
    public static void main(String[] args) throws InterruptedException {
        // exchanger is to exchange data from thread to another thread
        final Exchanger<String> exchanger = new Exchanger<>();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(()->{
            try {
                String data = exchanger.exchange("first");
                System.out.println(data + " in first thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            try {
                String data = exchanger.exchange("second");
                System.out.println(data + " in second thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}

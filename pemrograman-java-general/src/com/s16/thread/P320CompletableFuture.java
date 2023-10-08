package com.s16.thread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class P320CompletableFuture {
    private static void p01CompletableFutureExecute() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Supplier<Future<String>> supplier = () -> {
            CompletableFuture<String> future = new CompletableFuture<>();

            executorService.execute(() -> {
                try {
                    Thread.sleep(2_000L);
                    future.complete("success");
                } catch (InterruptedException e) {
                    future.completeExceptionally(e);
                }
            });

            return future;
        };

        Future<String> future = supplier.get();
        System.out.println(future.get());

        executorService.shutdown();
    }

    private static void p02FastestThread() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Random random = new Random();

        BiConsumer<CompletableFuture<String>, String> biConsumer = (future, string) -> {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1_000L + random.nextInt(5_000));
                    future.complete(string);
                } catch (InterruptedException e) {
                    future.completeExceptionally(e);
                }
            });
        };

        CompletableFuture<String> future = new CompletableFuture<>();

        biConsumer.accept(future, "thread-1");
        biConsumer.accept(future, "thread-2");
        biConsumer.accept(future, "thread-3");
        biConsumer.accept(future, "thread-4");

        String fastestThread = future.get();
        System.out.println(fastestThread);

        executorService.shutdown();
    }

    private static void p03CompletionStage() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Supplier<CompletableFuture<String>> supplier = () -> {
            CompletableFuture<String> future = new CompletableFuture<>();

            executorService.execute(() -> {
                try {
                    Thread.sleep(2_000L);
                    future.complete("supriadi syafeie muhammad yusuf");
                } catch (InterruptedException e) {
                    future.completeExceptionally(e);
                }
            });

            return future;
        };

        CompletableFuture<String[]> future = supplier.get()
                .thenApply(String::toUpperCase)
                .thenApply(value -> value.split(" "));

        String[] results = future.get();

        for (var result : results) {
            System.out.println(result);
        }

        executorService.shutdown();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        p01CompletableFutureExecute();
//        p02FastestThread();
        p03CompletionStage();
    }
}

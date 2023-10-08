package com.s16.thread;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// future is to store data used by thread returning data
public class P319Future {
    private static void p01GetFutureValue() throws InterruptedException, ExecutionException {
        Callable<String> callable = () -> {
            Thread.sleep(5_000L);
            return "hi";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);

        while (!future.isDone()) {
            System.out.println("waiting future ....");
            Thread.sleep(1_000L);
        }

        String value = future.get(); // wait until future has value
        System.out.println(value);

        executorService.shutdown();
    }

    private static void p02CancelFuture() throws InterruptedException, ExecutionException {
        Callable<String> callable = () -> {
            Thread.sleep(5_000L);
            return "hi";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        System.out.println("Selesai future");

        Thread.sleep(2_000L);
        future.cancel(true); // send signal to interrupt this thread

        System.out.println(future.isCancelled());

        if ((!future.isCancelled())) {
            String value = future.get(); // wait until future has value
            System.out.println(value);
        }

        executorService.shutdown();
    }

    private static void p03InvokeAll() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<String>> callableList = IntStream.range(1, 11)
                .mapToObj(value -> (Callable<String>) () -> {
                    Thread.sleep(value * 500L);
                    return String.valueOf(value);
                })
                .collect(Collectors.toList());

        List<Future<String>> futures = executorService.invokeAll(callableList);

        for (var future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }

    private static void p04InvokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<String>> callableList = IntStream.range(1, 11)
                .mapToObj(value -> (Callable<String>) () -> {
                    Thread.sleep(value * 500L);
                    return String.valueOf(value);
                })
                .collect(Collectors.toList());

        // invoke any callable which can send fastest result
        String result = executorService.invokeAny(callableList);
        System.out.println(result);

        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        p01GetFutureValue();
//        p02CancelFuture();
//        p03InvokeAll();
        p04InvokeAny();
    }
}

package com.s16.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;

public class P337ParallelStream {
    private static void p01NonParallelStream() {

        System.out.println("\n============ Non parallel stream ================");

        long sum = IntStream.range(0, 1000)
                .peek(integer-> System.out.println(Thread.currentThread().getName() + " : " + integer))
                .mapToLong(Long::valueOf).sum();
        System.out.println(sum);
    }

    private static void p02ParallelStream() {

        System.out.println("\n============ Parallel stream ================");

        long sum = IntStream.range(0, 1000)
                .parallel() // make this stream parallel
                .peek(integer-> System.out.println(Thread.currentThread().getName() + " : " + integer))
                .mapToLong(Long::valueOf).sum();
        System.out.println(sum);
    }

    private static void p03ParallelStreamInDefinedPool() throws ExecutionException, InterruptedException {

        System.out.println("\n============ Parallel stream in defined pool ================");


        ForkJoinPool pool = new ForkJoinPool(2);

        ForkJoinTask<Long> forkJoinTask = pool.submit(() -> IntStream.range(0, 1000)
                .parallel() // make this stream parallel
                .peek(integer -> System.out.println(Thread.currentThread().getName() + " : " + integer))
                .mapToLong(Long::valueOf).sum());

        Long sum = forkJoinTask.get();

        pool.shutdown();

        System.out.println(sum);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // parallel stream is executed on ForkJoinPool

//        p01NonParallelStream();
//        p02ParallelStream();
        p03ParallelStreamInDefinedPool();
    }
}

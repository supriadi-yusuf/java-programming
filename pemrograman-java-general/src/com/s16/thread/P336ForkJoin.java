package com.s16.thread;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P336ForkJoin {
    private static void p01Create() {
        ForkJoinPool forkJoinPool1 = ForkJoinPool.commonPool();// create thread as much as cpu we have
        ForkJoinPool forkJoinPool2 = new ForkJoinPool(5); // create 5 threads

        ExecutorService executorService1 = Executors.newWorkStealingPool();// create thread as much as cpu we have
        ExecutorService executorService2 = Executors.newWorkStealingPool(5); // create 5 threads
    }

    private static class SimpleRecursiveAction extends RecursiveAction {
        final private List<Integer> integers;

        public SimpleRecursiveAction(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected void compute() {
            if (integers.size() < 10) {
                doCompute();
            } else {
                forkCompute();
            }
        }

        private void forkCompute() {
            List<Integer> integers1 = integers.subList(0, integers.size() / 2);
            List<Integer> integers2 = integers.subList(integers.size() / 2, integers.size());

            SimpleRecursiveAction task1 = new SimpleRecursiveAction(integers1);
            SimpleRecursiveAction task2 = new SimpleRecursiveAction(integers2);

            ForkJoinTask.invokeAll(task1, task2);
        }

        private void doCompute() {
            integers.forEach((integer) -> System.out.println(Thread.currentThread().getName() + " : " + integer));
        }

    }

    private static void p02RecursiveAction() throws InterruptedException {
        System.out.println("\n==================== Recursive Action ===========================");

        List<Integer> integers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        SimpleRecursiveAction task = new SimpleRecursiveAction(integers);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.execute(task);

        pool.awaitTermination(3, TimeUnit.SECONDS);
        pool.shutdown();
    }

    private static class SimpleRecursiveTask extends RecursiveTask<Long> {
        final private List<Integer> integers;

        public SimpleRecursiveTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected Long compute() {
            if (integers.size() < 10) {
                return doCompute();
            } else {
                return forkCompute();
            }
        }

        private Long forkCompute() {
            List<Integer> integers1 = integers.subList(0, integers.size() / 2);
            List<Integer> integers2 = integers.subList(integers.size() / 2, integers.size());

            SimpleRecursiveTask task1 = new SimpleRecursiveTask(integers1);
            SimpleRecursiveTask task2 = new SimpleRecursiveTask(integers2);

            ForkJoinTask.invokeAll(task1, task2);

            return task1.join() + task2.join();
        }

        private Long doCompute() {
            return integers.stream()
                    .mapToLong(Long::valueOf)
                    .peek(value -> System.out.println(Thread.currentThread().getName() + " : " + value))
                    .sum();
        }
    }

    private static void p02RecursiveTask() throws InterruptedException, ExecutionException {
        System.out.println("\n====================== Recursive Task ============================");

        List<Integer> integers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        SimpleRecursiveTask task = new SimpleRecursiveTask(integers);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        ForkJoinTask<Long> submitted = pool.submit(task);

        Long result = submitted.get();

        pool.shutdown();

        System.out.println("sum result : " + result);

        // check sum result without thread
        long sum = integers.stream().mapToLong(Long::valueOf).sum();
        System.out.println(sum);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // fork is splitting task into several parts.
        // purpose of fork is to utilize cpu
        // join is merging small task
        // it uses ForkJoinWorkerThread. The thread is in ForkJoinPool
        // ForkJoinPool is subclass of ExecutorService
        // ForkJoinPool needs ForkJoinTask.
        // ForkJoinTask is an abstract class. It has two subclasses : RecursiveAction and RecursiveTask
        // RecursiveAction does not return value ( just like Runnable)
        // RecursiveTask returns value ( just like Callable)

        p01Create();

        p02RecursiveAction();

        p02RecursiveTask();

    }
}

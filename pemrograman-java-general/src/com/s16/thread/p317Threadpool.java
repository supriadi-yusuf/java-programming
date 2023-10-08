package com.s16.thread;

import java.util.Queue;
import java.util.concurrent.*;

public class p317Threadpool {
    private static void p01CreateThreadPool() throws InterruptedException {
        int corePoolSize = 10; // minimum pool size
        int maximumPoolSize = 100; // maximum pool size
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);
        int keepAliveTime = 1;
        TimeUnit timeUnit = TimeUnit.SECONDS;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, queue);

        Runnable runnable = () -> {
            System.out.println("Runnable from thread : " + Thread.currentThread().getName());
        };

        threadPoolExecutor.execute(runnable);

        Thread.sleep(1_000L);

//        threadPoolExecutor.awaitTermination(3, TimeUnit.SECONDS);
        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
    }

    private static void p02TerminateThreadpool() throws InterruptedException {
        System.out.println("\n============================================================");

        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(1000);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.SECONDS, arrayBlockingQueue);

        for (int i = 0; i < 1000; i++) {

            final var task = i;

            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            threadPoolExecutor.execute(runnable);
        }

        Thread.sleep(5_000L);

//        threadPoolExecutor.awaitTermination(25,TimeUnit.SECONDS);
//        threadPoolExecutor.shutdown();
        threadPoolExecutor.shutdownNow();
    }

    private static void p03RejectedExecutionHandler() throws InterruptedException {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        // if total task is more than queue capacity (10, in this case), the task will be rejected, rejected execution handler will handle this problem.
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Task " + r + " is rejected");
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.SECONDS,
                arrayBlockingQueue, rejectedExecutionHandler);

        for (int i = 0; i < 1000; i++) {
            final var task = i;

            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public String toString() {
                    return "task-" + task;
                }
            };

            threadPoolExecutor.execute(runnable);
        }

        Thread.sleep(10_000L);
//        threadPoolExecutor.awaitTermination(1,TimeUnit.HOURS);
        threadPoolExecutor.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
//        p01CreateThreadPool();
//        p02TerminateThreadpool();
        p03RejectedExecutionHandler();

    }
}


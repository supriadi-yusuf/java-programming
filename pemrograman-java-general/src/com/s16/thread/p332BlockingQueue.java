package com.s16.thread;

import java.util.Comparator;
import java.util.concurrent.*;

public class p332BlockingQueue {
    private static void processBlockingQueue(BlockingQueue<String> blockingQueue)throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 1; i <= 10; i++) {
            final var task = i;
            executorService.execute(() -> {
                try {
                    blockingQueue.put("data-" + task);
                    System.out.println("finish put data-" + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    String data = blockingQueue.take();
                    System.out.println("receive data : " + data);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    break;
                }
            }
        });

        executorService.awaitTermination(12, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }

    private static void processBlockingDeque(BlockingDeque<String> blockingDeque)throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 1; i <= 10; i++) {
            final var task = i;
            executorService.execute(() -> {
                try {
                    blockingDeque.putLast("data-" + task);
                    System.out.println("finish put data-" + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    String data = blockingDeque.takeLast();
                    System.out.println("receive data : " + data);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    break;
                }
            }
        });

        executorService.awaitTermination(12, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }

    private static void processTransferQueue(TransferQueue<String> transferQueue)throws InterruptedException {
//        TransferQueue : when data comes into this queue, it will wait until the data is taken from the queue
//        before new data come
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 1; i <= 10; i++) {
            final var task = i;
            executorService.execute(() -> {
                try {
                    transferQueue.transfer("data-" + task);
                    System.out.println("finish put data-" + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    String data = transferQueue.take();
                    System.out.println("receive data : " + data);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    break;
                }
            }
        });

        executorService.awaitTermination(12, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n===========Array Blocking Queue ==================");
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
        processBlockingQueue(arrayBlockingQueue);

        System.out.println("\n==============Linked Blocking Queue==================");
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        processBlockingQueue(linkedBlockingQueue);

        System.out.println("\n==============Priority Blocking Queue==================");
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>(5, Comparator.reverseOrder());
        processBlockingQueue(priorityBlockingQueue);

        System.out.println("\n==============Delay Queue==================");

        System.out.println("\n==============Synchronous Queue==================");
        // SynchronousQueue : we can only insert new data if previous data has been taken out otherwise
        // we have to wait
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        processBlockingQueue(synchronousQueue);

        System.out.println("\n==============Linked Blocking Deque==================");
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        processBlockingDeque(linkedBlockingDeque);

        System.out.println("\n==============Linked Transfer Queue==================");
        // TransferQueue is rather similar to Synchronous queue
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();
        processTransferQueue(linkedTransferQueue);

    }
}

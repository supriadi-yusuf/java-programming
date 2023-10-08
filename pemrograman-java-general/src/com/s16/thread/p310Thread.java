package com.s16.thread;

public class p310Thread {
    private static void p01MainThread() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
    }

    private static void p02CreateThread() throws InterruptedException {
        System.out.println("\n========================");

        Runnable runnable = () -> {
            System.out.println("Hello from thread : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("application finish");
    }

    private static void p03ThreadSleep() throws InterruptedException {
        System.out.println("\n========================");

        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(3_000);

        System.out.println("application finish");
    }

    private static void p04ThreadJoin() throws InterruptedException {
        System.out.println("\n========================");

        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("waiting for complete");

        thread.join();// wait until thread is complete

        System.out.println("application finish");
    }

    private static void p05ThreadInterrupt() throws InterruptedException {
        System.out.println("\n========================");

        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();

            for (int i = 1; i <= 10; i++) {
                if (thread.isInterrupted()) {
                    System.out.println(thread.getName() + " is interrupted");
                    return;
                }
                System.out.println("iteration : " + i);

                System.out.println("Hello from thread : " + thread.getName());

                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println("exception -> thread is interrupted : " + e.getMessage());
                    return;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(5_000);
        thread.interrupt();

        System.out.println("waiting for complete");

        thread.join();// wait until thread is complete

        System.out.println("application finish");
    }

    private static void p06ThreadName() {
        Thread thread = new Thread(() -> {
            System.out.println("Run in thread : " + Thread.currentThread().getName());
        });

        thread.setName("thread-printing"); // set name of thread
        thread.start();
    }

    private static void p07ThreadState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread.State threadState = Thread.currentThread().getState();
            System.out.println("Hello (from thread) : " + Thread.currentThread().getName());
            System.out.println("Thread state is (from thread) : " + threadState);
        });

        Thread.State threadState = thread.getState();
        System.out.println("Thread state is : " + threadState);

        thread.start();

        threadState = thread.getState();
        System.out.println("Thread state is : " + threadState);

        thread.join();

        threadState = thread.getState();
        System.out.println("Thread state is : " + threadState);
    }

    private static void p08UserThread() {
        // user thread vs diamond thread
        // user thread : java will not terminate this thread until it is completely executed.
        // diamond thread : java may be terminate this thread event it is not completely executed.
        // thread is user thread by default, to make it diamond we need method setDiamond()
        // but all thread will be terminated if System.exit() method is called

        Thread thread = new Thread(()->{
            System.out.println("user thread is started");
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user thread is complete");
        });

        thread.start();
    }

    private static void p09DiamondThread() {
        // user thread vs diamond thread
        // user thread : java will not terminate this thread until it is completely executed.
        // diamond thread : java may be terminate this thread event it is not completely executed.
        // thread is user thread by default, to make it diamond we need method setDiamond()
        // but all thread will be terminated if System.exit() method is called

        Thread thread = new Thread(()->{

            System.out.println("diamond thread is started");

            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("diamond thread is complete");
        });

        thread.setDaemon(true);
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
//        p01MainThread();
//        p02CreateThread();
//        p03ThreadSleep();
//        p04ThreadJoin();
//        p05ThreadInterrupt();
//        p06ThreadName();
//        p07ThreadState();
//        p08UserThread();
        p09DiamondThread();

    }
}

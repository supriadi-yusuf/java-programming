package com.s16.thread;

public class P312Synchronization {
    private static abstract class Counter {
        protected Long counter = 0L;

        public abstract void increment();

        public Long getCounter() {
            return counter;
        }
    }

    private static void p01SynchronizeMethod() {
        Counter counter = new Counter() {
            @Override // synchronized this method to solve race condition problem
            public synchronized void increment() {
                this.counter++;
            }
        };

        Runnable runnable = () -> {
            for(int i=0; i<1000;i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCounter()); // it should display 3000
    }

    private static void p02SynchronizeStatement() {
        Counter counter = new Counter() {
            @Override
            public void increment() {
                synchronized (this) { // synchronized this block of statement to solve race condition problem
                    // with keyword synchronized(Object). We can choose any object actually
                    this.counter++;
                }
            }
        };

        Runnable runnable = () -> {
            for(int i=0; i<1000;i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCounter()); // it should display 3000
    }

    public static void main(String[] args) {

        p01SynchronizeMethod();
        p02SynchronizeStatement();

    }
}

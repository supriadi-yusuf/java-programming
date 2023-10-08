package com.s16.thread;

public class P311RaceCondition {
    private static class Counter{
        private Long counter = 0L;

        public void increment(){
            counter++;
        }

        public Long getCounter(){
            return counter;
        }
    }

    private static void p01NormalExecution() {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for(int i=0; i<1000;i++) {
                counter.increment();
            }
        };

        runnable.run();
        runnable.run();
        runnable.run();

        System.out.println(counter.getCounter()); // it should 3000
    }

    private static void p02RaceConditionProblem() {

        // problem where variable is changed by more than one thread at the same time.
        // it makes the variable is not accurate

        Counter counter = new Counter();
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
//        p01NormalExecution();
        p02RaceConditionProblem();
    }
}

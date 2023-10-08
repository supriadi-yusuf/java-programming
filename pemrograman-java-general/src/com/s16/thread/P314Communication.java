package com.s16.thread;

import java.sql.Struct;

public class P314Communication {
    private static String message = null;

    private static void p01WaitAndNotify() {
        final var lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // lock is automatically released. lock must come before notify
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("thread1 finish .......");
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "hello semua";
                lock.notify(); // notify must come after wait
            }
            System.out.println("thread2 finish .......");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void p02WaitAndNotifyAll() {

        System.out.println("\n========================================");

        final var lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // lock is automatically released. lock() must come before notify()
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("thread1 finish .......");
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // lock is automatically released. lock() must come before notify()
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("thread3 finish .......");
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "hello semua";
                lock.notifyAll(); // notify() must come after wait()
            }
            System.out.println("thread2 finish .......");
        });

        thread1.start();
        thread3.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        p01WaitAndNotify();
        p02WaitAndNotifyAll();
    }
}

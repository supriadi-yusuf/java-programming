package com.s16.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

public class P324Lock {
    private static interface IValue {
        void incrementValue();

        Long getValue();
    }

    private static void p01Lock() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        final IValue valueOperation = new IValue() {
            private Long value = 0L;

            @Override
            public void incrementValue() {
                try {
                    lock.lock();
                    value++;
                } finally {
                    lock.unlock();
                }
            }

            @Override
            public Long getValue() {
                return value;
            }
        };

        final Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                valueOperation.incrementValue();
            }
        };

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ExecutorService executorService4 = Executors.newSingleThreadExecutor();
        ExecutorService executorService5 = Executors.newSingleThreadExecutor();

        executorService1.execute(runnable);
        executorService2.execute(runnable);
        executorService3.execute(runnable);
        executorService4.execute(runnable);
        executorService5.execute(runnable);

        Thread.sleep(3_000);

        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
        executorService4.shutdown();
        executorService5.shutdown();

        System.out.println(valueOperation.getValue());
    }

    private static void p02ReadWriteLock() throws InterruptedException {

        final ReadWriteLock lock = new ReentrantReadWriteLock();

        final IValue valueOperation = new IValue() {
            private Long value = 0L;

            @Override
            public void incrementValue() {
                try {
                    lock.writeLock().lock();
                    value++;
                } finally {
                    lock.writeLock().unlock();
                }
            }

            @Override
            public Long getValue() {
                try {
                    lock.readLock().lock();
                    return value;
                } finally {
                    lock.readLock().unlock();
                }
            }
        };

        final Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                valueOperation.incrementValue();
            }
        };

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ExecutorService executorService4 = Executors.newSingleThreadExecutor();
        ExecutorService executorService5 = Executors.newSingleThreadExecutor();

        executorService1.execute(runnable);
        executorService2.execute(runnable);
        executorService3.execute(runnable);
        executorService4.execute(runnable);
        executorService5.execute(runnable);

        Thread.sleep(3_000);

        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
        executorService4.shutdown();
        executorService5.shutdown();

        System.out.println(valueOperation.getValue());
    }

    private static void p03ConditionAwaitAndSignal() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        executorService1.execute(() -> {
            try {
                lock.lock();
                condition.await(); // it is like wait(), lock is automatically releases
                System.out.println("signal received");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executorService2.execute(() -> {
            try {
                lock.lock();
                System.out.println("send signal");
                condition.signal(); // it is like notify()
            } finally {
                lock.unlock();
            }
        });

        executorService1.shutdown();
        executorService2.shutdown();
    }

    private static void p04ConditionManyAwaitsAndSignalAll() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        executorService1.execute(() -> {
            try {
                lock.lock();
                condition.await(); // it is like wait(), lock is automatically releases
                System.out.println("signal received 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executorService3.execute(() -> {
            try {
                lock.lock();
                condition.await(); // it is like wait(), lock is automatically releases
                System.out.println("signal received 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executorService2.execute(() -> {
            try {
                lock.lock();
                System.out.println("send signal to all");
                condition.signalAll(); // it is like notifyAll()
            } finally {
                lock.unlock();
            }
        });

        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
//        p01Lock();
//        p02ReadWriteLock();
//        p03ConditionAwaitAndSignal();
        p04ConditionManyAwaitsAndSignalAll();
    }
}

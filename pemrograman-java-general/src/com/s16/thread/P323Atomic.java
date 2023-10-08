package com.s16.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class P323Atomic {

    private static interface IValue{
        void incrementValue();
        Long getValue();
    }

    public static void main(String[] args) throws InterruptedException {
        // java.util.concurrent.atomic contains classes to solve concurrency problem

        final IValue valueOperation = new IValue() {
            private Long value = 0L;

            @Override
            public void incrementValue() {
                value++;
            }

            @Override
            public Long getValue() {
                return value;
            }
        };

        AtomicLong atomicLong = new AtomicLong(0L);

        Runnable runnable = ()->{
          for (int i=0;i<1_000;i++){
              atomicLong.incrementAndGet();
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

        Thread.sleep(3_000);;

        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
        executorService4.shutdown();
        executorService5.shutdown();

        System.out.println(atomicLong.get());
        System.out.println(valueOperation.getValue());

    }
}

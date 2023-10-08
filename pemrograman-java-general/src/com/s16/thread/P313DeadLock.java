package com.s16.thread;

import java.text.NumberFormat;
import java.util.Locale;

public class P313DeadLock {
    private static class Balance {

        private Long value = 0L;

        public Balance(Long value) {
            this.value = value;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

    }

    @FunctionalInterface
    private static interface ITransfer {
        void doTransfer(Balance from, Balance to, Long value) throws InterruptedException;
    }

    private static void p01DeadLock() {
        ITransfer transfer = (from,to,value)->{
            synchronized (from) {
                    Thread.sleep(1_000);
                    from.setValue(from.getValue() - value);

                    synchronized (to) {
                        Thread.sleep(1_000L);
                        to.setValue(to.getValue() + value);
                    }
                }
        };

        Balance balance1 = new Balance(1_000_000L);
        Balance balance2 = new Balance(1_000_000L);

        Thread thread1 = new Thread(() -> {
            try {
                transfer.doTransfer(balance1, balance2, 1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                transfer.doTransfer(balance2, balance1, 1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(balance1.getValue());
        System.out.println(balance2.getValue());

    }

    private static void p02SolveDeadLock() {

        ITransfer transfer = (from, to, value) -> {
                synchronized (from) {
                    Thread.sleep(1_000);
                    from.setValue(from.getValue() - value);
                }

                synchronized (to) {
                    Thread.sleep(1_000L);
                    to.setValue(to.getValue() + value);
                }
        };

        Balance balance1 = new Balance(1_000_000L);
        Balance balance2 = new Balance(1_000_000L);

        Thread thread1 = new Thread(() -> {
            try {
                transfer.doTransfer(balance1, balance2, 1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                transfer.doTransfer(balance2, balance1, 1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        System.out.println(numberFormat.format(balance1.getValue()));
        System.out.println(numberFormat.format(balance2.getValue()));

    }

    public static void main(String[] args) {
//        p01DeadLock();
        p02SolveDeadLock();
    }
}

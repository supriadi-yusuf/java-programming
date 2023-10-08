package com.s16.thread;

import java.util.Timer;
import java.util.TimerTask;

public class P315Timer {
    private static void p01TimerSchedule() throws InterruptedException {
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        timer.schedule(timerTask,1_000);

        Thread.sleep(2000L);
        timer.cancel(); // terminate timer thread

        System.out.println("finish ....");
    }

    private static void p02TimerPeriod() {

        System.out.println("\n=================================");

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        timer.schedule(timerTask,2_000L,1_000L);

        System.out.println("finish ....");
    }

    public static void main(String[] args) throws InterruptedException {
        p01TimerSchedule();
        p02TimerPeriod();
    }
}

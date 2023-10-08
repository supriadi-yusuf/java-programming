package com.s15.datetime;

import java.time.LocalTime;

public class P292LocalTime {
    private static void p01CreateLocalTime() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(13, 15, 10);
        LocalTime localTime2 = LocalTime.parse("06:08:10");

        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    private static void p02ChangeLocalTime() {
        System.out.println("\n=================================");

        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.withHour(13);
        LocalTime localTime2 = localTime1.withMinute(5);
        LocalTime localTime3 = localTime2.withSecond(17);

        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    private static void p03ManipulateLocalTime() {
        System.out.println("\n=================================");

        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.plusHours(3);
        LocalTime localTime2 = localTime1.minusMinutes(10);
        LocalTime localTime3 = localTime2.plusSeconds(15);

        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    private static void p04GetLocalTime() {
        System.out.println("\n=================================");

        LocalTime localTime = LocalTime.now();

        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
    }

    public static void main(String[] args) {
        p01CreateLocalTime();
        p02ChangeLocalTime();
        p03ManipulateLocalTime();
        p04GetLocalTime();
    }
}

package com.s15.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class P293LocalDateTime {
    private static void p01CreateLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(1977, 2, 19, 17, 50, 14);
        LocalDateTime localDateTime2 = LocalDateTime.parse("1977-02-19T17:50:14");

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    private static void p02ChangeLocalDateTimeValue() {
        System.out.println("\n============================================");

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withYear(1970);
        LocalDateTime localDateTime2 = localDateTime1.withMonth(9);
        LocalDateTime localDateTime3 = localDateTime2.withHour(7);
        LocalDateTime localDateTime4 = localDateTime3.withSecond(20);

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
    }

    private static void p03ManipulateLocalDateTime() {
        System.out.println("\n============================================");

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusYears(10);
        LocalDateTime localDateTime2 = localDateTime1.plusDays(9);
        LocalDateTime localDateTime3 = localDateTime2.plusHours(7);
        LocalDateTime localDateTime4 = localDateTime3.minusSeconds(20);

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
    }

    private static void p04GetInfoLocalDateTime() {
        System.out.println("\n============================================");

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
    }

    private static void p05ConversionLocalDateTime() {
        System.out.println("\n========================");

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDateTime localDateTime1 = localDate.atTime(10, 05, 30);
        LocalDateTime localDateTime2 = localTime.atDate(localDate);

        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    public static void main(String[] args) {
        p01CreateLocalDateTime();
        p02ChangeLocalDateTimeValue();
        p03ManipulateLocalDateTime();
        p04GetInfoLocalDateTime();
        p05ConversionLocalDateTime();
    }
}

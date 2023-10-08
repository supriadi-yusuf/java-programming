package com.s15.datetime;

import java.time.LocalDate;
import java.time.Month;

public class P291LocalDate {
    private static void p01CreateLocalDate() {
        LocalDate localDateNow = LocalDate.now();
        LocalDate localDateOf = LocalDate.of(1977, Month.FEBRUARY, 19);
        LocalDate localDateParse = LocalDate.parse("1977-02-19");

        System.out.println(localDateNow);
        System.out.println(localDateOf);
        System.out.println(localDateParse);
    }

    private static void p02ChangeLocalDate() {
        System.out.println("\n=====================================");

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate localDate2 = localDate.withYear(1978);
        System.out.println(localDate2);

        LocalDate localDate3 = localDate2.withMonth(1);
        System.out.println(localDate3);

        LocalDate localDate4 = localDate3.withDayOfMonth(30);
        System.out.println(localDate4);
    }

    private static void p03ManipulatingLocalDate() {
        System.out.println("\n===========================");

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate localDate1 = localDate.plusYears(1);
        System.out.println("local date 1 : " + localDate1);

        LocalDate localDate2 = localDate1.minusMonths(2);
        System.out.println("local date 2 : " + localDate2);

        LocalDate localDate3 = localDate2.plusDays(3);
        System.out.println("local date 3 : " + localDate3);

        System.out.println(localDate3.isAfter(localDate3.minusMonths(1)));
        System.out.println(localDate3.isAfter(localDate3.plusMonths(1)));
    }

    private static void p04LocalDateGetInfo() {
        System.out.println("\n=======================");

        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfWeek().getValue());
        System.out.println(localDate.getDayOfYear());
    }

    public static void main(String[] args) {
        p01CreateLocalDate();
        p02ChangeLocalDate();
        p03ManipulatingLocalDate();
        p04LocalDateGetInfo();


    }
}

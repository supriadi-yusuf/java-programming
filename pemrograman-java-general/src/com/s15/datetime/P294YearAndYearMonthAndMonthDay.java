package com.s15.datetime;

import java.time.*;

public class P294YearAndYearMonthAndMonthDay {
    private static void p01CreateYear() {
        Year year = Year.now();
        Year year1 = Year.of(1970);
        Year year2 = Year.parse("1980");

        System.out.println(year);
        System.out.println(year1);
        System.out.println(year2);
    }

    private static void p02CreateYearMonth() {
        System.out.println("\n========================================");

        YearMonth yearMonth = YearMonth.now();
        YearMonth yearMonth1 = YearMonth.of(1970, Month.FEBRUARY);
        YearMonth yearMonth2 = YearMonth.parse("1980-06");

        System.out.println(yearMonth);
        System.out.println(yearMonth1);
        System.out.println(yearMonth2);
    }

    private static void p03CreateMonthDay() {
        System.out.println("\n================================");

        MonthDay monthDay = MonthDay.now();
        MonthDay monthDay1 = MonthDay.of(Month.JULY, 18);
        MonthDay monthDay2 = MonthDay.parse("--09-30");

        System.out.println(monthDay);
        System.out.println(monthDay1);
        System.out.println(monthDay2);
    }

    private static void p04ConvertData() {
        System.out.println("\n=================================");

        Year year = Year.now();
        YearMonth yearMonth = year.atMonth(Month.JULY);
        LocalDate localDate = yearMonth.atDay(20);
        Year year1 = Year.from(localDate);
        Month month = Month.from(localDate);
        MonthDay monthDay = MonthDay.from(localDate);

        System.out.println(year1);
        System.out.println(month);
        System.out.println(monthDay);
    }

    private static void p05GetInfo() {
        System.out.println("\n================================");

        LocalDate localDate = LocalDate.now();
        YearMonth yearMonth = YearMonth.from(localDate);
        MonthDay monthDay = MonthDay.from(localDate);

        System.out.println(localDate.getYear());
        System.out.println(yearMonth.getMonthValue());
        System.out.println(monthDay.getDayOfMonth());
    }

    public static void main(String[] args) {
        p01CreateYear();
        p02CreateYearMonth();
        p03CreateMonthDay();
        p04ConvertData();
        p05GetInfo();

    }
}

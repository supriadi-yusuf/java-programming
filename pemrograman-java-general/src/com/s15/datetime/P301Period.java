package com.s15.datetime;

import java.io.PipedWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class P301Period {
    private static void p01CreatePeriod() {
        Period period = Period.ofDays(10);
        Period period1 = Period.ofWeeks(10);
        Period period2 = Period.ofMonths(10);
        Period period3 = Period.ofYears(10);
        Period period4 = Period.of(2020, 10, 15);

        System.out.println(period);
        System.out.println(period1);
        System.out.println(period2);
        System.out.println(period3);
        System.out.println(period4);
    }

    private static void p02GetInfoPeriod() {
        System.out.println("\n===============================");

        Period period = Period.of(10, 15, 20);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    private static void p03Between() {
        System.out.println("\n===============================");

        Period period = Period.between(LocalDate.of(1977, Month.FEBRUARY, 9),
                LocalDate.now());

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    public static void main(String[] args) {
        p01CreatePeriod();
        p02GetInfoPeriod();
        p03Between();
    }
}

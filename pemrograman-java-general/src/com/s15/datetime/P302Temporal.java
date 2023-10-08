package com.s15.datetime;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

public class P302Temporal {
    private static void p01Temporal() {
        Temporal temporal = LocalDate.now();
        Temporal temporal1 = LocalTime.now();
        Temporal temporal2 = ZonedDateTime.now();
        Temporal temporal3 = Year.now();

        System.out.println(temporal);
        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
    }

    private static void p02TemporalAmount() {
        System.out.println("\n===========================================");

        TemporalAmount temporalAmount = Duration.of(3, ChronoUnit.HOURS);
        TemporalAmount temporalAmount2 = Period.of(1,3,2);

        System.out.println(temporalAmount);
        System.out.println(temporalAmount2);
    }

    private static void p03TemporalUnit() {
        // TemporalUnit is implemented on ChronoUnit
        System.out.println("\n====================================");

        long minutes = ChronoUnit.MINUTES.between(LocalTime.now(), LocalTime.now().plusHours(2));
        System.out.println(minutes);
    }

    private static void p04TemporalField() {
        // ChronoField implements TemporalField

        System.out.println("\n==================================");

        Temporal temporal = LocalDateTime.now();

        int years = temporal.get(ChronoField.YEAR);
        int months = temporal.get(ChronoField.MONTH_OF_YEAR);
        int days = temporal.get(ChronoField.DAY_OF_MONTH);
        int hours = temporal.get(ChronoField.HOUR_OF_DAY);
        int minute = temporal.get(ChronoField.MINUTE_OF_HOUR);
        int second = temporal.get(ChronoField.SECOND_OF_MINUTE);
        int milliOfSecond = temporal.get(ChronoField.MILLI_OF_SECOND);
        int nanoOfSecond = temporal.get(ChronoField.NANO_OF_SECOND);

        System.out.println(years);
        System.out.println(months);
        System.out.println(days);
        System.out.println(hours);
        System.out.println(minute);
        System.out.println(second);
        System.out.println(milliOfSecond);
        System.out.println(nanoOfSecond);
    }

    private static void p05TemporalQuery() {
        System.out.println("\n=========================================");

        Temporal temporal = LocalDateTime.now();

        List<Integer> integers = temporal.query(t -> {
            List<Integer> list = new ArrayList<>();

            list.add(t.get(ChronoField.YEAR));
            list.add(t.get(ChronoField.MONTH_OF_YEAR));
            list.add(t.get(ChronoField.DAY_OF_MONTH));

            return list;
        });

        System.out.println(integers);
    }

    private static void p06TemporalAdjuster() {
        System.out.println("\n========================================");

        Temporal temporal = LocalDateTime.now();

        Temporal temporal1 = temporal.with(t -> {
            return LocalDateTime.of(
                    t.get(ChronoField.YEAR) + 2,
                    t.get(ChronoField.MONTH_OF_YEAR),
                    t.get(ChronoField.DAY_OF_MONTH),
                    t.get(ChronoField.HOUR_OF_DAY),
                    t.get(ChronoField.MINUTE_OF_HOUR),
                    t.get(ChronoField.SECOND_OF_MINUTE)
            );
        });

        Temporal temporal2 = temporal.with(TemporalAdjusters.firstDayOfMonth());
        Temporal temporal3 = temporal.with(TemporalAdjusters.lastDayOfMonth());
        Temporal temporal4 = temporal.with(TemporalAdjusters.firstDayOfYear());
        Temporal temporal5 = temporal.with(TemporalAdjusters.lastDayOfYear());

        Temporal temporal6 = temporal.with(ChronoField.MONTH_OF_YEAR, Month.DECEMBER.getValue());

        System.out.println(temporal);
        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);
        System.out.println(temporal5);
        System.out.println(temporal6);
    }

    public static void main(String[] args) {
        p01Temporal();
        p02TemporalAmount();
        p03TemporalUnit();
        p04TemporalField();
        p05TemporalQuery();
        p06TemporalAdjuster();

    }
}

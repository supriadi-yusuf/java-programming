package com.s15.datetime;

import java.time.*;

public class P299Clock {
    private static void p01CreateClock() {
        Clock clock = Clock.systemUTC();
        Clock clock1 = Clock.systemDefaultZone();
        Clock clock2 = Clock.system(ZoneId.of("Asia/Jakarta"));

        System.out.println(clock);
        System.out.println(clock1);
        System.out.println(clock2);
    }

    private static void p02ToInstant() throws InterruptedException {
        System.out.println("\n==============================");

        Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

        Instant instant = clock.instant();
        System.out.println(instant);

        Thread.sleep(1_000);

        Instant instant1 = clock.instant();
        System.out.println(instant1);
    }

    private static void p03FromClock() {
        System.out.println("\n============================================");

        Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));
        System.out.println(clock);

        Year year = Year.now(clock);
        System.out.println(year);

        YearMonth yearMonth = YearMonth.now(clock);
        System.out.println(yearMonth);

        MonthDay monthDay = MonthDay.now(clock);
        System.out.println(monthDay);

        LocalTime localTime = LocalTime.now(clock);
        System.out.println(localTime);

        LocalDate localDate = LocalDate.now(clock);
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.now(clock);
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
        System.out.println(zonedDateTime);
    }

    public static void main(String[] args) throws InterruptedException {

        p01CreateClock();
        p02ToInstant();
        p03FromClock();

    }
}

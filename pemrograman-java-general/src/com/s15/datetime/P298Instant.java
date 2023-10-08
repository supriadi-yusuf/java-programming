package com.s15.datetime;

import java.time.*;

public class P298Instant {
    private static void p01CreateInstant() {

        // instant use time zone UTC

        Instant instant = Instant.now();
        Instant instant1 = Instant.ofEpochMilli(System.currentTimeMillis());
        Instant instant2 = instant.minusMillis(10000000L);

        System.out.println(instant);
        System.out.println(instant1);
        System.out.println(instant2);
    }

    private static void p02GetInfoInstant() {
        System.out.println("\n================================");

        Instant instant = Instant.now();
        long epochMilli = instant.toEpochMilli();
        long epochSecond = instant.getEpochSecond();
        int instantNano = instant.getNano();

        System.out.println(epochMilli);
        System.out.println(epochSecond);
        System.out.println(instantNano);
    }

    private static void p03ConvertInstant() {
        System.out.println("\n=======================================");

        Instant instant = Instant.now();
        ZoneId zoneJakarta = ZoneId.of("Asia/Jakarta");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneJakarta);
        LocalDate localDate = LocalDate.ofInstant(instant, zoneJakarta);
        LocalTime localTime = LocalTime.ofInstant(instant, zoneJakarta);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneJakarta);
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, zoneJakarta);

        System.out.println(instant);
        System.out.println(zoneJakarta);
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(zonedDateTime);
        System.out.println(offsetDateTime);
    }

    private static void p04ToInstant() {
        System.out.println("\n=================================================");

        Instant instant = LocalDateTime.now().toInstant(ZoneOffset.ofHours(7));
        Instant instant1 = ZonedDateTime.now().toInstant();
        Instant instant2 = OffsetDateTime.now().toInstant();

        System.out.println(instant);
        System.out.println(instant1);
        System.out.println(instant2);
    }

    public static void main(String[] args) {
        p01CreateInstant();
        p02GetInfoInstant();
        p03ConvertInstant();
        p04ToInstant();

    }
}

package com.s15.datetime;

import java.time.*;

public class P297OffsetTimeAndOffsetDateTime {
    private static void p01CreateOffsetTime() {
        //offset time : time with zone offset
        OffsetTime offsetTime = OffsetTime.now();
        OffsetTime offsetTime1 = OffsetTime.now(ZoneId.of("GMT"));
        OffsetTime offsetTime2 = OffsetTime.of(10, 10, 10,10, ZoneOffset.of("+07:00"));
        OffsetTime offsetTime3 = OffsetTime.parse("13:39:26.788924857+07:00");

        System.out.println(offsetTime);
        System.out.println(offsetTime1);
        System.out.println(offsetTime2);
        System.out.println(offsetTime3);
    }

    private static void p02CreateOffsetDateTime() {
        System.out.println("\n===============================");

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        OffsetDateTime offsetDateTime1 = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
        OffsetDateTime offsetDateTime2 = OffsetDateTime.now(ZoneOffset.ofHours(7));
        OffsetDateTime offsetDateTime3 = OffsetDateTime.parse("2023-08-27T13:46:16.156587965+07:00");

        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime2);
        System.out.println(offsetDateTime3);
    }

    private static void p03ConvertOffsetTime() {
        System.out.println("\n================================");

        LocalTime localTime = LocalTime.now();
        OffsetTime offsetTime = localTime.atOffset(ZoneOffset.ofHours(7));
        LocalTime localTime1 = offsetTime.toLocalTime();
        LocalTime localTime2 = LocalTime.from(offsetTime);

        ZoneOffset offset = offsetTime.getOffset();
        ZoneOffset offset1 = ZoneOffset.from(offsetTime);

        System.out.println(localTime);
        System.out.println(offsetTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(offset);
        System.out.println(offset1);

    }

    private static void p04ConvertOffsetDateTime() {
        System.out.println("\n==================================");

        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(7));
        LocalDateTime localDateTime1 = offsetDateTime.toLocalDateTime();
        LocalDate localDate = offsetDateTime.toLocalDate();
        LocalTime localTime = offsetDateTime.toLocalTime();
        OffsetTime offsetTime = offsetDateTime.toOffsetTime();
        ZonedDateTime zonedDateTime = offsetDateTime.toZonedDateTime();

        System.out.println(localDateTime);
        System.out.println(offsetDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(offsetTime);
        System.out.println(zonedDateTime);
    }

    public static void main(String[] args) {
        p01CreateOffsetTime();
        p02CreateOffsetDateTime();
        p03ConvertOffsetTime();
        p04ConvertOffsetDateTime();
    }
}

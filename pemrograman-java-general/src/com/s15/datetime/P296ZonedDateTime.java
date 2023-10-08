package com.s15.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class P296ZonedDateTime {
    private static void p01CreateZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneOffset.ofHours(-5));
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jakarta"));

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
    }

    private static void p02ParsingZonedDateTime() {
        System.out.println("\n==========================================================");

        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2023-08-27T10:52:32.018311307+07:00[Asia/Jakarta]");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2023-08-27T10:52:32.018311307+05:00[Asia/Jakarta]"); // with wrong hour, hour should be ignored
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2023-08-27T10:52:32.018311307+05:00");

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
    }

    private static void p03ChangeZone() {
        System.out.println("\n==========================================================");

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameLocal(ZoneId.of("GMT"));// change zone only, not time
        ZonedDateTime zonedDateTime2 = zonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));// change zone and time

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
    }

    public static void main(String[] args) {
        p01CreateZonedDateTime();
        p02ParsingZonedDateTime();
        p03ChangeZone();

    }
}

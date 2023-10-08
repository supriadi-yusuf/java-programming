package com.s15.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class P305LegacyDateAndTime {
    private static void p01ConvertFromLegacy() {
        Date date = new Date();
        System.out.println(date);
        Instant instant = date.toInstant();
        System.out.println(instant);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Instant instant1 = calendar.toInstant();
        System.out.println(instant1);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);
        ZoneId zoneId = timeZone.toZoneId();
        System.out.println(zoneId);
    }

    public static void main(String[] args) {

        p01ConvertFromLegacy();

        System.out.println("\n=================================");

        Instant instant = Instant.now();
        System.out.println(instant);

        Date date = Date.from(instant);
        System.out.println(date);

        ZoneId zoneIndonesia = ZoneId.of("Asia/Jakarta");
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneIndonesia);
        Calendar calendar = GregorianCalendar.from(zonedDateTime);
        System.out.println(calendar);

        TimeZone timeZone = TimeZone.getTimeZone(zoneIndonesia);
        System.out.println(timeZone);

    }
}

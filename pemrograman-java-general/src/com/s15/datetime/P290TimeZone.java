package com.s15.datetime;

import java.lang.ref.Cleaner;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class P290TimeZone {
    private static void p01CreateTimeZone() {
        TimeZone timeZoneDefault = TimeZone.getDefault();
        System.out.println(timeZoneDefault);

        TimeZone timeZoneJkt = TimeZone.getTimeZone("Asia/Jakarta");
        System.out.println(timeZoneJkt);

        String[] timezoneIds = TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(timezoneIds));
    }

    private static void p02Calendar() {
        System.out.println("\n===================================");

        Calendar calendarJakarta = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY));

        calendarJakarta.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
    }

    public static void main(String[] args) {

        p01CreateTimeZone();

        p02Calendar();

    }
}

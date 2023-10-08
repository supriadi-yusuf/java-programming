package com.s15.datetime;

import java.time.ZoneId;
import java.time.ZoneOffset;

public class P295ZoneIdAndZoneOffset {
    private static void p01CreateZoneId() {
        // zone id is representation of time zone

        ZoneId zoneId = ZoneId.systemDefault();
        ZoneId zoneId1 = ZoneId.of("Asia/Jakarta");

        System.out.println(zoneId);
        System.out.println(zoneId1);
    }

    private static void p02CreateZoneOffset() {

        // ZoneOffset is subclass of ZoneId

        ZoneOffset zoneOffset = ZoneOffset.of("+07:00");
        ZoneOffset zoneOffset1 = ZoneOffset.ofHours(-7);
        ZoneOffset zoneOffset2 = ZoneOffset.ofHoursMinutes(7, 30);

        System.out.println(zoneOffset);
        System.out.println(zoneOffset1);
        System.out.println(zoneOffset2);
    }

    public static void main(String[] args) {

        p01CreateZoneId();
        p02CreateZoneOffset();


    }
}

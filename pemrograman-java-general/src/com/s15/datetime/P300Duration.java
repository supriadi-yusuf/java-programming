package com.s15.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class P300Duration {
    private static void p01CreateDuration() {
        Duration duration = Duration.ofHours(10);
        Duration duration1 = Duration.ofMinutes(10);
        Duration duration2 = Duration.ofMillis(10);

        System.out.println(duration);
        System.out.println(duration1);
        System.out.println(duration2);
    }

    private static void p02FromDuration() {
        System.out.println("\n=========================================");

        Duration duration = Duration.ofHours(10);

        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
    }

    private static void p03Between() {
        System.out.println("\n================================================");

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusHours(10).plusMinutes(30);
        Duration duration = Duration.between(localDateTime, localDateTime1);
        Duration duration1 = Duration.between(localDateTime1, localDateTime);

        System.out.println(duration.toHours());
        System.out.println(duration1.toHours());
    }

    public static void main(String[] args) {
        p01CreateDuration();
        p02FromDuration();
        p03Between();

    }
}

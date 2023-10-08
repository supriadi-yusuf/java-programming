package com.s15.datetime;

import java.time.DayOfWeek;

public class P303DayOfWeek {
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        DayOfWeek dayOfWeek1 = dayOfWeek.plus(2);
        DayOfWeek dayOfWeek2 = dayOfWeek.minus(1);

        System.out.println(dayOfWeek);
        System.out.println(dayOfWeek1);
        System.out.println(dayOfWeek2);

    }
}

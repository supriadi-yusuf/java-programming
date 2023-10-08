package com.s04.standard;

// Date represents date time with milli second precision
// Calendar is to manipulate date time

import java.util.Calendar;
import java.util.Date;

public class P110DateAndCalendar {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.AUGUST);
        calendar.set(Calendar.DATE, 20);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 10);
        calendar.set(Calendar.MILLISECOND, 100);

        Date time = calendar.getTime();
        System.out.println(time);

    }
}

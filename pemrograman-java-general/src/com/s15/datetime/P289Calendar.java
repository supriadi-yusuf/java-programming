package com.s15.datetime;

import java.util.Calendar;
import java.util.Date;

public class P289Calendar {
    private static void p01CreateDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(date.getTime()); // display milliseconds
    }

    private static void p02SettingCalendar() {

        System.out.println("\n=========================================");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,1977);
        calendar.set(Calendar.MONTH,Calendar.FEBRUARY);
        calendar.set(Calendar.DAY_OF_MONTH,19);
        calendar.set(Calendar.HOUR_OF_DAY,10);
        calendar.set(Calendar.MINUTE,20);
        calendar.set(Calendar.SECOND,30);

        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(date.getTime()); // display milliseconds
    }

    private static void p03GetCalendar() {
        System.out.println("\n=========================================");

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));

        Date date = calendar.getTime();
        System.out.println(date);
    }

    public static void main(String[] args) {
        p01CreateDate();
        p02SettingCalendar();
        p03GetCalendar();

    }
}

package com.s14.internationalization;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class P279I18NDateAndTime {
    private static void p01DateFormat() {
        String pattern = "EEEE dd MMMM yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        String format = dateFormat.format(new Date());

        System.out.println(format);
    }

    private static void p02DateFormatIndonesia() {
        Locale locale = new Locale("id", "ID");

        String pattern = "EEEE dd MMMM yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern,locale);

        String format = dateFormat.format(new Date());

        System.out.println(format);
    }

    private static void p03DateFormatJapan() {
        Locale locale = new Locale("ja", "JP");

        String pattern = "EEEE dd MMMM yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern,locale);

        String format = dateFormat.format(new Date());

        System.out.println(format);
    }

    private static void p04DateFormatParseIndonesia() {
        Locale locale = new Locale("id", "ID");

        String pattern = "EEEE dd MMMM yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern,locale);
        String dateIndonesia = "Jumat 25 Agustus 2023";

        try {
            Date date = dateFormat.parse(dateIndonesia);
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("Error parse : " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        // Internationalization (short : I18N)
        p01DateFormat();
        p02DateFormatIndonesia();
        p03DateFormatJapan();
        p04DateFormatParseIndonesia();
    }
}

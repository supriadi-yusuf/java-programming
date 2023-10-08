package com.s14.internationalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class P280I18NNumber {
    private static void p01NumberFormat() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String format = numberFormat.format(10000000.255);
        System.out.println(format);
    }

    private static void p02NumberFormatIndonesia() {
        Locale localIndonesia = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getInstance(localIndonesia);
        String format = numberFormat.format(10000000.255);
        System.out.println(format);
    }

    private static void p03NumberFormatParseIndonesia() {
        Locale localIndonesia = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getInstance(localIndonesia);
        String indonesiaNumber = "10.000.000,255";

        try {
            double value = numberFormat.parse(indonesiaNumber).doubleValue();
            System.out.println(value);
        } catch (ParseException e) {
            System.out.println("Error parse number : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        p01NumberFormat();
        p02NumberFormatIndonesia();
        p03NumberFormatParseIndonesia();

    }
}

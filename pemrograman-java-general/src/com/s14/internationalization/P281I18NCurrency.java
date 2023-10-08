package com.s14.internationalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class P281I18NCurrency {
    private static void p01CurrencyIndonesiaInfo() {
        Locale locale = new Locale("id", "ID");
        Currency currency = Currency.getInstance(locale);

        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getDisplayName());
        System.out.println(currency.getSymbol());
    }

    private static void p02CurrencyIndonesiaFormat() {
        Locale locale = new Locale("id", "ID");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        String format = currencyInstance.format(100000000.255);
        System.out.println(format);
    }

    private static void p03CurrencyIndonesiaParse() {
        Locale locale = new Locale("id", "ID");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);

        try {
            double value = currencyInstance.parse("Rp100.000.000,25").doubleValue();
            System.out.println(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        p01CurrencyIndonesiaInfo();
        p02CurrencyIndonesiaFormat();
        p03CurrencyIndonesiaParse();

    }
}

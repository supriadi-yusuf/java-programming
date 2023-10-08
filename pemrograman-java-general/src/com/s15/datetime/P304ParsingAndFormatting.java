package com.s15.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class P304ParsingAndFormatting {
    private static void p01DefaultFormat() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate localDate = LocalDate.now();
        String formattedLocalDate = localDate.format(dateTimeFormatter);
        System.out.println(formattedLocalDate);
    }

    private static void p02Formatting() {

        System.out.println("\n===================================================");

        String pattern = "yyyy MM dd";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        LocalDate localDate = LocalDate.now();
        String localDateString = localDate.format(dateTimeFormatter);

        System.out.println(localDateString);
    }

    private static void p03Parsing() {
        System.out.println("\n=========================================");

        String pattern = "yyyy MM dd";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        LocalDate localDate = LocalDate.parse("2023 08 10", dateTimeFormatter);
        System.out.println(localDate);
    }

    private static void p04Internationalization() {
        System.out.println("\n==============================================");

        Locale locale = new Locale("id", "ID");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", locale);

        LocalDate localDate = LocalDate.of(2020, 3, 15);
        String localDateString = localDate.format(formatter);

        System.out.println(localDateString);
    }

    public static void main(String[] args) {
        p01DefaultFormat();
        p02Formatting();
        p03Parsing();
        p04Internationalization();

    }
}

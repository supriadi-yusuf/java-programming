package com.s14.internationalization;

import java.util.Locale;

public class P277Locale {
    public static void main(String[] args) {
        // language code : https://www.loc.gov/standards/iso639-2/php/code_list.php
        String languageCode = "id"; // indonesian

        // country code : https://www.iban.com/country-codes
        String countryCode = "ID";

        Locale locale = new Locale(languageCode, countryCode);

        System.out.println("language code : " + locale.getLanguage());
        System.out.println("country code : " + locale.getCountry());

        System.out.println("language name : " + locale.getDisplayLanguage());
        System.out.println("country name : " + locale.getDisplayCountry());
    }
}

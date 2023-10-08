package com.s14.internationalization;

import java.text.MessageFormat;

public class P282MessageFormat {
    public static void main(String[] args) {
        String pattern = "Hi {0}, Anda bisa mencari data Anda dengan mengetikkan \"{0}\" di pencarian";
        MessageFormat messageFormat = new MessageFormat(pattern);
        String format = messageFormat.format(new Object[]{"supriadi"});
        System.out.println(format);
    }
}

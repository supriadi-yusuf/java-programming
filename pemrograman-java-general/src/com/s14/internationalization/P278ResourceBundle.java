package com.s14.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class P278ResourceBundle {
    private static void p01ResourceBundle() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    private static void p02ResourceBundleIndonesia() {
        Locale localIndonesia = new Locale("id", "ID");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message",localIndonesia);

        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    public static void main(String[] args) {
//        p01ResourceBundle();
//        p02ResourceBundleIndonesia();

        // pattern : https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
    }
}

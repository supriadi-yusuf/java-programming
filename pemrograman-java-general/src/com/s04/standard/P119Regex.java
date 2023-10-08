package com.s04.standard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P119Regex {
    public static void main(String[] args) {
        String kalimat = "I am a java programmer ok";
        System.out.println(kalimat);

        // criteria to find
        Pattern pattern = Pattern.compile("[a-zA-Z]*a[a-z-Z]*[^r]");
        Matcher matcher = pattern.matcher(kalimat);

        while (matcher.find()){
            String result = matcher.group();
            System.out.println(result);
        }

        String email = "supriadi81@gmail.com";
        System.out.println(email);

        Pattern patternEmail = Pattern.compile("[a-zA-Z]+[0-9]*@[a-zA-Z]+[.][a-z]{2,3}");
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matches = matcherEmail.matches();
        System.out.println(matches);

    }
}

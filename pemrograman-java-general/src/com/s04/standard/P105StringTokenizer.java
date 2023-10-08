package com.s04.standard;

// StringTokenizer is to split token
// String.split() is not good to split string when the string is huge because it will consume a lot of memory
// In that condition StringTokenizer is better to use

import java.util.StringTokenizer;

public class P105StringTokenizer {
    public static void main(String[] args) {

        String kalimat = "Saya adalah programmer java";

        StringTokenizer stringTokenizer = new StringTokenizer(kalimat," ");

        // split
        while (stringTokenizer.hasMoreTokens()){
            String string = stringTokenizer.nextToken();
            System.out.println(string);
        }


    }
}

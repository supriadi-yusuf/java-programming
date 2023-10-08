package com.s04.standard;

// StringJoiner is to join string with certain format

import java.util.StringJoiner;

public class P104StringJoiner {
    public static void main(String[] args) {

        StringJoiner stringJoiner = new StringJoiner("||", "(", ")");

        stringJoiner.add("Saya");
        stringJoiner.add("adalah");
        stringJoiner.add("programmer");
        stringJoiner.add("java");

        String string = stringJoiner.toString();

        System.out.println(string);


    }
}

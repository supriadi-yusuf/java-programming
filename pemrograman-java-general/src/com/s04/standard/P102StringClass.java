package com.s04.standard;

import java.util.Arrays;

// String bukan tipe data primitif
// String adalah kelas
// String merupakan tipe data immutable

public class P102StringClass {
    public static void main(String[] args) {
        String kalimat = "Saya adalah programmer java";
        String upperCase = kalimat.toUpperCase();
        String lowerCase = kalimat.toLowerCase();

        System.out.println(kalimat);
        System.out.println(upperCase);
        System.out.println(lowerCase);
        System.out.println(kalimat.length());
        System.out.println(kalimat.startsWith("Saya"));
        System.out.println(kalimat.endsWith("java"));

        String[] words = kalimat.split(" ");
        System.out.println(Arrays.toString(words));

        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());

        System.out.println(kalimat.charAt(0));

        char[] charArray = kalimat.toCharArray();
        System.out.println(Arrays.toString(charArray));

    }
}

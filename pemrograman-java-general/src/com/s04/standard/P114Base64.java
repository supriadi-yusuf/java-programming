package com.s04.standard;

import java.util.Base64;

public class P114Base64 {
    public static void main(String[] args) {

        String kalimat = "Saya adalah programmer java";
        System.out.println("Original : " + kalimat);

        System.out.println("\nencoding string to base64 .......... \n");

        byte[] bytes = kalimat.getBytes();
        byte[] encResult = Base64.getEncoder().encode(bytes);
        String resultString = new String(encResult);

        System.out.println(resultString);

        System.out.println("\ndecode Base64 to string..................\n");

        byte[] resultStringBytes = resultString.getBytes();
        byte[] decodeBytes = Base64.getDecoder().decode(resultStringBytes);

        String decodeResult = new String(decodeBytes);
        System.out.println(decodeResult);

    }
}

package com.s04.standard;

import java.util.Random;

public class P116Random {
    public static void main(String[] args) {
        Random random = new Random();

        for (var i = 1; i <= 100; i++) {
            int randomValue = random.nextInt(1000000); // generate random value
            System.out.println(randomValue);
        }
    }
}

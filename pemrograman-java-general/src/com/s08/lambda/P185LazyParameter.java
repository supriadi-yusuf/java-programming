package com.s08.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class P185LazyParameter {
    public static void main(String[] args) {

        testScore(80, getName());
        testScore(60, getName());

        testScoreWithLazyParam(80, () -> getName());
        testScoreWithLazyParam(60, () -> getName());
    }

    public static void testScore(int score, String name) {
        if (score >= 80) {
            System.out.println("Selamat " + name + ", Anda Lulus.");
        } else {
            System.out.println("Coba lagi tahun depan");
        }
    }

    public static void testScoreWithLazyParam(int score, Supplier<String> name) {
        if (score >= 80) {
            System.out.println("Selamat " + name.get() + ", Anda Lulus.");
        } else {
            System.out.println("Coba lagi tahun depan");
        }
    }

    public static String getName() {
        System.out.println("=============== method getName() dipanggil ================");
        return "supriadi";
    }
}

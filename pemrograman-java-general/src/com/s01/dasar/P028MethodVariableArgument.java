package com.s01.dasar;

public class P028MethodVariableArgument {
    public static void main(String[] args) {
        sayCongrats("supriadi", 80, 60, 90, 70);

        int[] nilai = {80,80,60,70};
        sayCongrats("eko", nilai);
    }

    public static void sayCongrats(String name, int... values){
        double total = 0;
        for (var value:values) {
            total += value;
        }

        var finalValue = total / values.length;
        if (finalValue >= 75) {
            System.out.println("Selamat " + name + ", anda lulus");
        }else {
            System.out.println("Maaf "+name+", anda tidak lulus");
        }
    }

}

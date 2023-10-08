package com.s04.standard;

import java.util.Arrays;

public class P118Arrays {
    public static void main(String[] args) {

        int[] numbers={100,56,343,23,87,54,989,43,65,9, 14,66,76,87,656,8};
        System.out.println(Arrays.toString(numbers));

        // copy
        int[] copyResults = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copyResults));

        // check if equal
        boolean isEqual = Arrays.equals(numbers, copyResults);
        System.out.println(isEqual);

        int[] copyOfRange = Arrays.copyOfRange(numbers, 2, 4);
        System.out.println(Arrays.toString(copyOfRange));
        System.out.println(Arrays.equals(numbers,copyOfRange));

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        int bsResult = Arrays.binarySearch(numbers, 100);
        System.out.println(bsResult);

        // negative means searching not found
        int binarySearch = Arrays.binarySearch(numbers,200);
        System.out.println(binarySearch);

        String[] names = {"Andi","Imran","David"};
        Object[] objects = names;
        System.out.println(Arrays.toString(objects));

    }
}

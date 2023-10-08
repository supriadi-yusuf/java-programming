package com.s07.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P172BinarySearch {
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>(1000);
        for (int i=1; i<=1000;i++){
            integers.add(i);
        }

        int searchResult = Collections.binarySearch(integers, 110);
        System.out.println(searchResult);

        searchResult = Collections.binarySearch(integers, 1100);
        System.out.println(searchResult);

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        searchResult=Collections.binarySearch(integers,110,comparator);
        System.out.println(searchResult);

        searchResult=Collections.binarySearch(integers,1100,comparator);
        System.out.println(searchResult);

    }
}

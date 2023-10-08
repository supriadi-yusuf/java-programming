package com.s07.collection;

import java.util.*;

public class P171Sorting {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(List.of("supriadi", "syafeie", "muhammad", "yusuf"));
        ArrayList<String> arrayListDesc = new ArrayList<>(arrayList);

        System.out.println(arrayList.toString());

        Collections.sort(arrayList);
        System.out.println(arrayList.toString());

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        Collections.sort(arrayListDesc,comparator);
        System.out.println(arrayListDesc.toString());
    }
}

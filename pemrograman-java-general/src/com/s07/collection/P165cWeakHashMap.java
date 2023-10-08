package com.s07.collection;

import java.util.WeakHashMap;

// data in map will be removed randomly by garbage collector

public class P165cWeakHashMap {
    public static void main(String[] args) {
        WeakHashMap<Integer, Integer> map = new WeakHashMap<>();
        for (Integer i = 0; i < 100_000_000; i++) {
            map.put(i, i);
        }

        System.out.println(map.size());

        System.gc();
        System.gc();

        System.out.println(map.size());
    }
}

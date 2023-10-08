package com.s07.collection;

import java.util.IdentityHashMap;

// IdentityHashMap : key comparison uses reference not value

public class P165cIdentityHashMap {
    public static void main(String[] args) {
        IdentityHashMap<String, String> map = new IdentityHashMap<>();

        String key = "key";
        String key1 = "key1";
        String keySatu = key + "1";

        System.out.println("=========== key equality ==========");
        System.out.println(key1.equals(keySatu));

        map.put(key1,"value");
        map.put(keySatu,"value2");

        System.out.println("\n========== keys =================");
        for (var kunci:map.keySet()){
            System.out.println(kunci);
        }

        System.out.println("\n========== map size ============");
        System.out.println(map.size());
    }
}

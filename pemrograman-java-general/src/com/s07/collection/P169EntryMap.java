package com.s07.collection;

import java.util.Map;
import java.util.Set;

public class P169EntryMap {
    public static void main(String[] args) {
        Map<String, String> map = Map.<String, String>of("supriadi", "supriadi", "syafeie", "syafeie",
                "muhammad", "muhammad", "yusuf", "yusuf");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        System.out.println(entrySet.size());

        for (var entry:entrySet){
            System.out.println(entry.toString());
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

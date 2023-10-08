package com.s07.collection;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class P168NavigableMap {
    public static void main(String[] args) {
        Map<String, String> map = Map.<String, String>of("supriadi", "supriadi", "syafeie", "syafeie",
                "muhammad", "muhammad", "yusuf", "yusuf");

        System.out.println("======== Navigable Map =========");
        NavigableMap<String, String> navigableMap = new TreeMap<>(map);
        navigableMap.put("indonesia","indonesia");

        System.out.println("map : " + navigableMap.toString());
        System.out.println("keys : " + navigableMap.keySet().toString());

        NavigableMap<String, String> navigableMapDesc = navigableMap.descendingMap();
        System.out.println("descending map : " + navigableMapDesc.toString());

        String lowSyafeie = navigableMap.lowerKey("syafeie");
        System.out.println("lower than syafeie : " + lowSyafeie);

        System.out.println("higher than syafeie : " + navigableMap.higherKey("syafeie"));
    }
}

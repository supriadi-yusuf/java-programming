package com.s07.collection;

import java.util.*;

public class P167SortedMap {
    public static void dispayKeys(SortedMap<String,String>map){

        System.out.println("Sorted Map => " + map.toString());

        Set<String> keySet = map.keySet();
        System.out.println("keys : " + keySet.toString());

        System.out.println("First key : " + map.firstKey());
        System.out.println("Last key : " + map.lastKey());

        SortedMap<String, String> headMap = map.headMap("syaefi");
        System.out.println("head : " + headMap.toString());

        SortedMap<String, String> tailMap = map.tailMap("syafei");
        System.out.println("tail : " + tailMap.toString());

    }

    public static void main(String[] args) {

        Map<String, String> map = Map.<String, String>of("supriadi", "supriadi", "syafei", "syafei",
                "muhammad", "muhammad", "yusuf", "yusuf");

        System.out.println("======== Sorted Map =========");
        TreeMap<String, String> treeMap = new TreeMap<>(map);
        treeMap.put("indonesia","indonesia");
        dispayKeys(treeMap);

        System.out.println("\n======== Sorted Map with Comparator =========");
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        TreeMap<String, String> treeMapDesc = new TreeMap<>(comparator);
        treeMapDesc.put("indonesia","indonesia");
        treeMapDesc.putAll(map);
        dispayKeys(treeMapDesc);

    }
}

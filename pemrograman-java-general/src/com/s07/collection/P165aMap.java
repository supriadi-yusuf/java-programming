package com.s07.collection;

import java.util.*;

// Map is interface
// Map has child interface SortedMap
// SortedMap has child interface NavigableMap
// Map is implemented by HashMap, IdentityHashMap, LinkedHashMap, EnumMap, TreeMap
// HashMap has child LinkedHasMap
// SortedMap and NavigableMap are implemented by TreeMap

public class P165aMap {

    public static void executeMap(Map<Integer, Integer> map) {

        for (Integer i = 1; i <= 10; i++) {
            map.put(i, i * 10);
        }

        System.out.println(map.size());

        Set<Integer> keys = map.keySet();
        for(var key: keys){
            System.out.println(map.get(key));
        }

        System.out.println("Remove key");

        Integer[] keysArray = keys.toArray(new Integer[0]);
        for(var key: keysArray){
            map.remove(key);
        }

        System.out.println("key size : " + keys.size());
        System.out.println(Arrays.toString(keysArray));

    }

    public static void main(String[] args) {

        System.out.println("========== Hash Map ===========");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        executeMap(hashMap);

        System.out.println("\n============ Linked Hash Map ============");
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        executeMap(linkedHashMap);
    }
}

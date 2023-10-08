package com.s07.collection;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Set;

// EnumMap : type of key is enum

public class P165bEnumMap {
    public static enum Level {
        FREE, STANDARD, PREMIUM, VIP
    }

    public static void main(String[] args) {

        EnumMap<Level, String> enumMap = new EnumMap<>(Level.class);

        Set<Level> keys = enumMap.keySet();
        System.out.println(keys.size());

        Collection<String> values = enumMap.values();
        System.out.println(values.size());

        enumMap.put(Level.STANDARD, "standard");
        enumMap.put(Level.PREMIUM, "premium");

        keys = enumMap.keySet();
        System.out.println(keys.size());

        values = enumMap.values();
        System.out.println(values.size());

        for (var key : keys) {
            String value = enumMap.get(key);
            System.out.println(value);
        }

        enumMap.put(Level.STANDARD,"double standard");
        System.out.println(enumMap.get(Level.STANDARD));

        enumMap.remove(Level.STANDARD);
        System.out.println(enumMap.get(Level.STANDARD));

        System.out.println(enumMap.keySet().size());

    }
}

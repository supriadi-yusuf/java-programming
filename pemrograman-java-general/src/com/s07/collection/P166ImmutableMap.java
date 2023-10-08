package com.s07.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P166ImmutableMap {
    public static void main(String[] args) {

        // mutable map
        HashMap<String, String> mutableMap = new HashMap<>(Map.of("1","Satu","2","Dua","3","Tiga"));
        mutableMap.put("4", "Empat");

        // immutable map
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(mutableMap);
        Map<String, String> emptyMap = Collections.<String, String>emptyMap();
        Map<String, String> singletonMap = Collections.<String, String>singletonMap("1", "Satu");
        Map<String, String> map = Map.<String, String>of("first.name", "Supriadi", "middle.name", "Muhammad", "last.name", "Yusuf");
    }
}

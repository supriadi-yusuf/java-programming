package com.s07.collection;

// Iterable is parent of every Collection class in java
// Iterable has method iterator() which returns Iterator

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class P155IterableAndInterator {
    public static void main(String[] args) {
        Iterable<String> iterable = Arrays.<String>asList("supri", "yudha", "anto");

        Iterator<String> iterator = iterable.iterator();
        while (iterator.hasNext()){
            String data = iterator.next();
            System.out.println(data);
        }

        System.out.println("-----------------------------------------");

        // or we can simply use
        for(var data : iterable){
            System.out.println(data);
        }

    }
}

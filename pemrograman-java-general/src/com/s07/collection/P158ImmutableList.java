package com.s07.collection;

import java.util.*;

// immutable list is a list than can not be modified

public class P158ImmutableList {
    public static void main(String[] args) {

        // mutable list
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a"); // ok
        arrayList.addAll(List.of("b","c"));

        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.addAll(List.of("b","c"));

        // immutable list
        List<String> emptyList = Collections.<String>emptyList();
//        emptyList.add("a"); // error, because it is immutable list

        List<String> singletonList = Collections.<String>singletonList("a");
//        singletonList.add("a"); // error, because it is immutable

        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
//        unmodifiableList.add("test"); // error, because it is immutable

        List<String> list = List.of("a", "b", "c");
//        list.add("test"); // error, because it is immutable

        List<String> arrayAsList = Arrays.asList("a", "b", "c");
//        arrayAsList.add("test"); // error, because it is immutable

    }

}

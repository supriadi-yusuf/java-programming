package com.s07.collection;

import java.util.*;

// Set is interface. It is child of Collection.
// Set does not have duplicate data. every data has hashcode
// Set is implemented by class : EnumSet, HashSet, LinkedHashSet and TreeSet
// Set has child interface SortedSet
// SortedSet has child interface NavigableSet
// NavigableSet is implemented by class TreeSet

// HashSet => sequence data in the set is not same as the sequence it is stored
// LinkedHashList => sequence data in the set is same as the sequence it is stored
public class P159aSet {

    public static void main(String[] args) {

        System.out.println("============ Hash Set ==============");
        Set<String> hashSet = new HashSet<>();
        executeSet(hashSet);

        System.out.println("==================== Linked Hash Set ====================");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        executeSet(linkedHashSet);

    }

    public static void executeSet(Set<String> set){
        set.add("k");
        set.addAll(List.of("c","l","b"));
        set.add("m");
        set.add("j");

        showSet(set);
    }

    private static void showSet(Set<? extends Object> set) {
        for(var data : set){
            System.out.println(data);
        }
    }
}

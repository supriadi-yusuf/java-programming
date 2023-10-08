package com.s07.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P160ImmutableSet {
    public static void main(String[] args) {
        Set<String> emptySet = Collections.<String>emptySet();
//        emptySet.add("test"); // error because it is immutable set

        Set<String> singleton = Collections.<String>singleton("test");
//        singleton.add("test"); // error because it is immutable set

        Set<String> set = Set.<String>of("a", "b", "c");
//        set.add("test"); // error because it is immutable set

        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(Set.of("a","b","c"));

        Set<String> unmodifiableSet = Collections.unmodifiableSet(hashSet);
//        unmodifiableSet.add("test");
    }
}

package com.s07.collection;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

// NavigableSet has method to searching element less than or greater than, reverse order of data, etc

// NavigableSet is child of SortedSet
// NavigableSet is implemented by TreeSet

public class P162NavigableSet {
    public static void main(String[] args) {

        System.out.println("Navigable set : ");
        NavigableSet<String> navigableSet = new TreeSet<>();
        navigableSet.addAll(Set.of("supriadi","muhammad","yusuf","syafeie","programmer","professional","java"));
        showSet(navigableSet);

        System.out.println("\nDescending : ");
        NavigableSet<String> descendingSet = navigableSet.descendingSet();
        showSet(descendingSet);

        System.out.println("\nHead : ");
        NavigableSet<String> headSet = navigableSet.headSet("programmer", true);
        showSet(headSet);

        System.out.println("\nTail : ");
        NavigableSet<String> tailSet = navigableSet.tailSet("programmer", true);
        showSet(tailSet);

    }

    private static void showSet(Set<? extends Object> set) {

        System.out.println(Arrays.toString(set.toArray()));
    }
}

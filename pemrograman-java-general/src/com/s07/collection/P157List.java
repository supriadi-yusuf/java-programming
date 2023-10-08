package com.s07.collection;


// List is interface. It is child of Collection
// There are 2 implementation of List. They are ArrayList, LinkedList

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P157List {
    public static void initiateList(List<String> list) {

        list.add("a");
        list.add("b");
        list.add("c");

        String[] myData = {"d", "e", "f"};
        List<String> listOfMyData = List.of(myData);
        list.addAll(listOfMyData);

        String[] otherData = {"g", "h", "i"};
        List<String> arrayAsList = Arrays.asList(otherData);
        list.addAll(arrayAsList);

    }

    public static void printListAsArray(List<String> list){
        String[] arrayString = list.toArray(new String[0]);
        System.out.println(Arrays.toString(arrayString));
    }

    public static void processList(List<String> list){
        initiateList(list);
        printListAsArray(list);

        String element0 = list.get(0);
        System.out.println("Get element ke 0 : " + element0);

        System.out.println("add test to index 0");
        list.add(0, "test");
        printListAsArray(list);

        System.out.println("replace element 0");
        list.set(0,"replace");
        printListAsArray(list);

        System.out.println("Remove element 0");
        list.remove(0);
        printListAsArray(list);
    }

    public static void main(String[] args) {
        
        System.out.println("================ Array List =====================");
        ArrayList<String> arrayList = new ArrayList<>(20);
        processList(arrayList);

        System.out.println("================= Linked List =======================");
        LinkedList<String> linkedList = new LinkedList<>();
        processList(linkedList);

    }
}

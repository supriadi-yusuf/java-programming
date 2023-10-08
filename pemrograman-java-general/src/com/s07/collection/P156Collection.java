package com.s07.collection;

// Collection is interface to manipulate data
// Collection is sub type of Iterable
// Collection has child interface : List, Set, Queue

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class P156Collection {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();

        collection.add("Supriadi");
        collection.add("Yusuf");
        collection.addAll(List.<String>of("Programmer","Java","Professional"));

        for(var data : collection){
            System.out.println(data);
        }

        boolean isYusufExist = collection.contains("Yusuf");
        System.out.println(isYusufExist);

        List<String> objects = Arrays.<String>asList("Programmer", "Java", "Yusuf");
        boolean isDataExist = collection.containsAll(objects);
        System.out.println(isDataExist);

        int dataSize = collection.size();
        System.out.println(dataSize);

        System.out.println("============= remove Yusuf ===================");

        collection.remove("Yusuf");
        for(var data : collection){
            System.out.println(data);
        }

        System.out.println("========== remove : Java, Programmer");

        List<String> removed = List.<String>of("Java", "Programmer");
        collection.removeAll(removed);

        for(var data : collection){
            System.out.println(data);
        }

    }
}

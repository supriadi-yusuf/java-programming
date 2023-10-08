package com.s07.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P173Collections {
    public static void main(String[] args) {
        ArrayList<String> arrayListOri = new ArrayList<>(List.of("supriadi", "syafeie", "muhammad", "yusuf",
                "adalah", "programmer", "java", "profesional", "yusuf"));

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        ArrayList<String> arrayList = new ArrayList<>(arrayListOri);

        int frequency = Collections.frequency(arrayList, "yusuf");
        System.out.println(frequency);

        String max = Collections.max(arrayList);
        System.out.println(max);

        String max2 = Collections.max(arrayList, comparator);
        System.out.println(max2);

        String min = Collections.min(arrayList);
        System.out.println(min);

        String min2 = Collections.min(arrayList, comparator);
        System.out.println(min2);

        System.out.println(arrayList);

        Collections.reverse(arrayList);
        System.out.println(arrayList);

        arrayList.clear();
        arrayList.addAll(arrayListOri);
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        Collections.copy(arrayList,arrayListOri);
        Collections.swap(arrayList,2,3);
        System.out.println(arrayList);


    }
}

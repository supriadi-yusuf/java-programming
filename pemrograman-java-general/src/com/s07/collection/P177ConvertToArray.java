package com.s07.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P177ConvertToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("supriadi", "syafeie", "muhammad", "yusuf",
                "adalah", "programmer", "java", "profesional", "yusuf"));

        String[] array = list.toArray(new String[]{});
        System.out.println(Arrays.toString(array));

    }
}

package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P355Array {
    private static void p01DescribeArray() {
        Class<String[]> stringArrayClass = String[].class;
        Class<int[][]> intArrayClass = int[][].class;
        Class<Person> personClass = Person.class;

        System.out.println(stringArrayClass.isArray());
        System.out.println(intArrayClass.isArray());
        System.out.println(personClass.isArray());

        System.out.println(Arrays.toString(stringArrayClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(stringArrayClass.getDeclaredFields()));
        System.out.println(Arrays.toString(stringArrayClass.getDeclaredMethods()));
        System.out.println(stringArrayClass.getComponentType());

        System.out.println(intArrayClass.getComponentType());
    }

    private static void p02ManipulateArray() {
        Class<String[]> aClass = String[].class;

        Class<?> componentType = aClass.getComponentType();
        String[] array = (String[]) Array.newInstance(componentType, 10);
        Array.set(array, 0, "tata");
        Array.set(array, 1, "dadang");

        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        p01DescribeArray();

        p02ManipulateArray();
    }


}

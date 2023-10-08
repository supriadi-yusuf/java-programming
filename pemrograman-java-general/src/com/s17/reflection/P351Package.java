package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.util.Arrays;

public class P351Package {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        Package aPackage = personClass.getPackage();

        System.out.println(aPackage.getName());
        System.out.println(Arrays.toString(aPackage.getAnnotations()));
    }
}

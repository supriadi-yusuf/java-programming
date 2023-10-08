package com.s17.reflection;

import com.s17.reflection.classes.Gender;

import java.util.Arrays;

public class P353Enum {
    public static void main(String[] args) {
        Class<Gender> genderClass = Gender.class;

        System.out.println(genderClass.getName());
        System.out.println(genderClass.isEnum());
        System.out.println(genderClass.getSuperclass());
        System.out.println(Arrays.toString(genderClass.getEnumConstants()));
        System.out.println(Arrays.toString(genderClass.getDeclaredFields()));
        System.out.println(Arrays.toString(genderClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(genderClass.getDeclaredMethods()));

    }
}

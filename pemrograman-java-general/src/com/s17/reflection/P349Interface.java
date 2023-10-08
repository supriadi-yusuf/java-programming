package com.s17.reflection;

import com.s17.reflection.classes.*;

import java.util.Arrays;

public class P349Interface {
    private static void p01Describe() {
        Class<IPerson> iPersonClass = IPerson.class;

        System.out.println(iPersonClass.getName());
        System.out.println(iPersonClass.isInterface());
        System.out.println(iPersonClass.getSuperclass());
        System.out.println(Arrays.toString(iPersonClass.getInterfaces()));
        System.out.println(Arrays.toString(iPersonClass.getDeclaredFields()));
        System.out.println(Arrays.toString(iPersonClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(iPersonClass.getDeclaredConstructors()));
    }

    private static void p02GetInterfaceImplemetedByClass() {
        System.out.println("\n============ Get Interface from class =============");

        Class<Person> personClass = Person.class;
        System.out.println(Arrays.toString(personClass.getInterfaces()));
    }

    public static void main(String[] args) {
        p01Describe();

        p02GetInterfaceImplemetedByClass();
    }
}

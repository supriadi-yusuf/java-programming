package com.s17.reflection;

import com.s17.reflection.classes.Person;

public class P343Class {

    private static void p01GetClass() throws ClassNotFoundException {
        Class<Person> personClass1 = Person.class;
        Class<?> personClass2 = Class.forName("com.s17.reflection.classes.Person");

        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        p01GetClass();

        Class<Person> personClass = Person.class;

        System.out.println(personClass.getSuperclass());
        System.out.println(personClass.getInterfaces());
        System.out.println(personClass.getDeclaredConstructors());
        System.out.println(personClass.getDeclaredMethods());
        System.out.println(personClass.getDeclaredFields());
        System.out.println(personClass.getModifiers());
        System.out.println(personClass.getPackage());
        System.out.println(personClass.getName());


    }
}

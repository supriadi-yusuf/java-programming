package com.s17.reflection;

import com.s17.reflection.classes.Person;

public class P348SuperClass {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        Class<? super Person> superclass2 = superclass.getSuperclass();
        System.out.println(superclass2);
    }
}

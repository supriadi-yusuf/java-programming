package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.lang.reflect.Modifier;

public class P350Modifier {
    public static void main(String[] args) {
        // private, protected, public, abstract, final
        Class<Person> personClass = Person.class;
        int modifiers = personClass.getModifiers();

        System.out.println(Modifier.isPublic(modifiers));
        System.out.println(Modifier.isFinal(modifiers));
        System.out.println(Modifier.isStatic(modifiers));
    }
}

package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class P347Constructor {
    private static void p01GetConstructor() {
        Class<Person> personClass = Person.class;

        Constructor<?>[] constructors = personClass.getConstructors();
        for (var constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {
        p01GetConstructor();

        System.out.println("\n================= Create object =======================");

        Class<Person> personClass = Person.class;

        try {
            Constructor<Person> constructor = personClass.getConstructor();
            Constructor<Person> constructorWithParams = personClass.getConstructor(String.class, String.class);

            Person person = constructor.newInstance();
            Person person2 = constructorWithParams.newInstance("Supriadi", "Yusuf");

            System.out.println(person);
            System.out.println(person2);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

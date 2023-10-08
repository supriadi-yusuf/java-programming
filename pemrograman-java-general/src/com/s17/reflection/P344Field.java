package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.lang.reflect.Field;

public class P344Field {
    private static void p01GetFields() {
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for(var field : fields){
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
        }
    }

    private static void p02AccessField() {
        Person person = new Person("Supriadi", "Yusuf");
        Class<? extends Person> personClass = person.getClass();
        try {
            Field firstNameField = personClass.getDeclaredField("firstName");

            // field firstName is private, so it can not modify by default
            // we have to change accessibility if we want to read/write it
            firstNameField.setAccessible(true);

            // get field value
            Object firstNameFieldContent = firstNameField.get(person);
            System.out.println(firstNameFieldContent);

            // set field value
            firstNameField.set(person,"ali");
            System.out.println(person.getFirstName());



        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        p01GetFields();
        p02AccessField();

    }
}

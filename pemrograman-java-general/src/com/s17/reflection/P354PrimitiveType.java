package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class P354PrimitiveType {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<Person> personClass = Person.class;

        Field field = personClass.getDeclaredField("age");

        System.out.println(field.getName());
        System.out.println(field.getType().isPrimitive());

        Person person = new Person("supriadi", "yusuf");
        person.setAge(25);

        field.setAccessible(true);
        System.out.println(field.getInt(person));

        Method setAge = personClass.getDeclaredMethod("setAge", int.class);
        setAge.invoke(person,30);

        System.out.println(person.getAge());
    }
}

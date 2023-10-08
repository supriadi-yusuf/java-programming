package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class P345Method {
    private static void p01GetMethods() {
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();

        for (var method:methods){
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString( method.getParameterTypes()));
            System.out.println(Arrays.toString( method.getExceptionTypes()));
            System.out.println("----------------------------------------");
        }
    }

    private static void p02InvokeMethod() {
        Class<Person> personClass = Person.class;

        try {
            Method getFirstName = personClass.getDeclaredMethod("getFirstName");

            Person person = new Person("Supriaid", "Yusuf");
            String firstName =(String) getFirstName.invoke(person);

            System.out.println(firstName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        p01GetMethods();
        p02InvokeMethod();
    }
}

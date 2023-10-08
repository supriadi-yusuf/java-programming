package com.s17.reflection;

import com.s17.reflection.classes.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class P346Parameter {
    private static void p01GetParameters() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        for (var method:methods){
            System.out.println("method : " + method.getName());
            System.out.println("return type : " + method.getReturnType());

            Parameter[] parameters = method.getParameters();
            for (var parameter:parameters){
                System.out.println("Parameter Name : " + parameter.getName());
                System.out.println("Parameter Type : " + parameter.getType());
            }

            System.out.println("-----------------------------------------");
        }
    }

    private static void p02InvokeMethodWithParameter() {
        System.out.println("\n============ Invoke method with parameters =================");

        Class<Person> personClass = Person.class;

        try {
            Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

            Person person = new Person("Supriaid", "Yusuf");
            System.out.println(person.getFirstName());

            setFirstName.invoke(person,"Ahmad");
            System.out.println(person.getFirstName());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        p01GetParameters();
        p02InvokeMethodWithParameter();
    }
}

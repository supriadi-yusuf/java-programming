package com.s17.reflection;

import com.s17.reflection.classes.Data;
import com.s17.reflection.classes.Person;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class P356ParameterizedType {
    private static void p01GenericTypeField() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;

        Field field = personClass.getDeclaredField("hobbies");
        System.out.println(field.getType());

        Type genericType = field.getGenericType();
        System.out.println(genericType);
        System.out.println(genericType.getClass());

        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;

            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getOwnerType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    private static void p02MethodReturnType() throws NoSuchMethodException {
        System.out.println("\n================== method return ==========================");
        Class<Person> personClass = Person.class;
        Method method = personClass.getDeclaredMethod("getHobbies");
        Type genericReturnType = method.getGenericReturnType();

        Class<? extends Type> genericReturnTypeClass = genericReturnType.getClass();
        System.out.println(genericReturnTypeClass);

        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getOwnerType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    private static void p03MethodParameter() throws NoSuchMethodException {
        System.out.println("\n================== method parameter ==========================");
        Class<Person> personClass = Person.class;
        Method method = personClass.getDeclaredMethod("setHobbies", List.class);
        Type[] parameterTypes = method.getGenericParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));

        for (var parameterType : parameterTypes) {
            Class<? extends Type> parameterTypeClass = parameterType.getClass();
            System.out.println(parameterTypeClass);

            if (parameterType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) parameterType;
                System.out.println(parameterizedType.getRawType());
                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            }
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        // handle generic type with parameterize type
        p01GenericTypeField();
        p02MethodReturnType();
        p03MethodParameter();

        // Type Variable

        System.out.println("\n=========== Type Variable =============");

        Class<Data> dataClass = Data.class;

        TypeVariable<Class<Data>>[] typeVariables = dataClass.getTypeParameters();
        System.out.println(Arrays.toString(typeVariables));

        for (var typeVariable:typeVariables){
            System.out.println(typeVariable.getName());
            System.out.println(Arrays.toString(typeVariable.getBounds()));
            System.out.println(typeVariable.getGenericDeclaration());
        }

    }
}

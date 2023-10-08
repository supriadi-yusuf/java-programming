package com.s17.reflection;

import com.s17.reflection.classes.Product;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class P358Record {
    private static void p01DescribeRecord() {
        Class<Product> productClass = Product.class;

        System.out.println(productClass.isRecord());
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));
    }

    private static void p02InvokeMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println("\n================= invoke method =====================");

        Class<Product> productClass = Product.class;

        Method id = productClass.getDeclaredMethod("id");

        Product product = new Product("T01", "Tissue Lipat", 50L);

        System.out.println(id.invoke(product));
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        p01DescribeRecord();
        p02InvokeMethod();

        System.out.println("\n============== Get Record Component ==================");

        Product product = new Product("G01", "Gelas plastik", 100L);

        Class<? extends Product> aClass = product.getClass();

        RecordComponent[] recordComponents = aClass.getRecordComponents();
        for (var recordComponent:recordComponents){
            Method accessor = recordComponent.getAccessor();

            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(product));
        }
    }
}

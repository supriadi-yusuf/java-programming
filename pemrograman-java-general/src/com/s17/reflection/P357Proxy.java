package com.s17.reflection;

import com.s17.reflection.classes.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class P357Proxy {
    public static void main(String[] args) {
        // proxy is to create artificial object (stub)
        // invocation handler will handle method invocation

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getName")) {
                    return "Car Proxy";
                }

                if (method.getName().equals("run")) {
                    System.out.println("Car is running");
                }

                return null;
            }
        };

        Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Car.class}, invocationHandler);

        System.out.println("car : " + car);
        System.out.println("name : " + car.getName());
        System.out.println("class : " + car.getClass());

        car.run();
    }
}

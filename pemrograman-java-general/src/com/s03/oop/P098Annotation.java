package com.s03.oop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface BelajarAnnotation{
    String name(); // mandatory
    String[] tags() default {}; // not mandatory because it has default value
}

@BelajarAnnotation(name = "test 123")
public class P098Annotation {
    public static void main(String[] args) {

    }
}

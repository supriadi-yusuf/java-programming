package com.s17.reflection.validators;

import com.s17.reflection.annotations.NotBlank;

import java.lang.reflect.Field;
import java.util.Objects;

public class Validator {
    public static void validateNotBlank(Object object) throws IllegalAccessException {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (var field : fields) {
            NotBlank notBlank = field.getAnnotation(NotBlank.class);
            if (notBlank != null) {
                field.setAccessible(true); // modify accessibility before get value
                String value = (String) field.get(object);
                if (notBlank.allowEmptyString()) {
                    // allow empty string
                    // ignore
                } else {
                    // not allow empty string
                    if (value != null) value = value.trim();
                }

                if (Objects.equals(value, "")) {
                    throw new RuntimeException(field.getName() + " must not be blank!");
                }
            }
        }
    }
}

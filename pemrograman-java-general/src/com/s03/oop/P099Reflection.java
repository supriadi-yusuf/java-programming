package com.s03.oop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class P099Reflection {

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    static @interface NotBlankAnnotation {
    }

    public static class ReflectionClass {
        @NotBlankAnnotation
        private String name;

        @NotBlankAnnotation
        private String city;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {

        ReflectionClass reflectionObj = new ReflectionClass();
        reflectionObj.setName("test");
        reflectionObj.setCity("");
        validationReflection(reflectionObj);

    }

    public static void validationReflection(Object object){
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (var field : fields){
            field.setAccessible(true); // normally if field is private it is not accessible so we force it to become accessible

            if (field.getAnnotation(NotBlankAnnotation.class) != null){
                // validated
                try {
                    Object value = field.get(object);

                    if (value == null){
                        throw new RuntimeException("Field " + field.getName() + " is null");
                    }

                    if ( value instanceof String){
                        String strValue = (String) value;
                        if (strValue==null || strValue.isBlank()){
                            throw new RuntimeException("Field " + field.getName() + " is blank");
                        }
                    }
                }catch (IllegalAccessException exception){
                    System.out.println("Tidak bisa mengakses field " + field.getName());
                }

            }
        }


    }
}

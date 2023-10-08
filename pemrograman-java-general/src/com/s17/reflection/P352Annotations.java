package com.s17.reflection;

import com.s17.reflection.annotations.NotBlank;
import com.s17.reflection.classes.Person;
import com.s17.reflection.validators.Validator;

public class P352Annotations {
    private static void p0xValidateWithAnnotation() {

        System.out.println("\n============== Validation with annotation ===============");

        Person nullPerson = new Person();
        Person emptyPerson = new Person("","");
        Person yusuf = new Person("", "yusuf");
        Person supriadi = new Person("supriadi", " ");
        Person person = new Person("supriadi", "yusuf");

        try {
            Validator.validateNotBlank(nullPerson);
        } catch (Throwable e) {
            System.out.println(emptyPerson);
            e.printStackTrace();
        }

        try {
            Validator.validateNotBlank(emptyPerson);
        } catch (Throwable e) {
            System.out.println(emptyPerson);
            e.printStackTrace();
        }

        try {
            Validator.validateNotBlank(yusuf);
        } catch (Throwable e) {
            System.out.println(yusuf);
            e.printStackTrace();
        }

        try {
            Validator.validateNotBlank(supriadi);
        } catch (Throwable e) {
            System.out.println(supriadi);
            e.printStackTrace();
        }

        try {
            Validator.validateNotBlank(person);
        } catch (Throwable e) {
            System.out.println(person);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Class<NotBlank> notBlankClass = NotBlank.class;

        System.out.println(notBlankClass.getName());
        System.out.println(notBlankClass.isAnnotation());
        System.out.println(notBlankClass.getSuperclass());
        System.out.println(notBlankClass.getAnnotatedSuperclass());

        p0xValidateWithAnnotation();

    }
}

package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class P10ConstructorValidationTest extends AbstractValidatorTest {

    @Test
    void validateConstructorParameter() throws NoSuchMethodException {

        ExecutableValidator executableValidator = getExecutableValidator();
//        Constructor<Person> constructor = Person.class.getDeclaredConstructor(String.class, String.class, Address.class);
        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);


        String firstName = "";
        String lastName = "";
        Address address = new Address();
        Set<ConstraintViolation<Object>> violations = executableValidator.validateConstructorParameters(constructor, new Object[]{firstName, lastName, address});
        for (var violation:violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============================");
        }
    }

    @Test
    void validateConstructorReturnValue() throws NoSuchMethodException {

        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Person person = new Person(firstName, lastName, address);

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

        ExecutableValidator executableValidator = getExecutableValidator();
        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorReturnValue(constructor, person);
        for (var violation:violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=========================");
        }

    }
}

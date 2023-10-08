package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Constraint is an annotation that is used as a marker for the target that we add
 * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/
 */
public class P02ConstraintViolationTest {
    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp(){
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown(){
        validatorFactory.close();
    }

    @Test
    void testValidationFailedNotBlank(){
        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(3, violations.size());

        for (var violation:violations){
            System.out.println("====================================");
            System.out.println(violation);
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value : " + violation.getInvalidValue());
//            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("Path : " + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationFailedSize(){
        Person person = new Person();
        person.setFirstName("fdsffffffffdfssssssssssssssssssssssssssssssssss");
        person.setLastName("fdsffffffffdfssssssssssssssssssssssssssssssssss");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(3, violations.size());

        for (var violation:violations){
            System.out.println("====================================");
            System.out.println(violation);
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value : " + violation.getInvalidValue());
//            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("Path : " + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationSuccess(){
        Person person = new Person();
        person.setFirstName("supriadi");
        person.setLastName("yusuf");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());

    }
}

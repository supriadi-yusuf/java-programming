package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

import java.util.Set;

public class P03NestedValidationTest {

    /*Nested validation : to validate field whose type is object. this kind of field is not validated by default.
    if we want the object validated we have to use @Valid annotation*/

    private Validator validator;
    private ValidatorFactory validatorFactory;

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
    void testNested(){
        Person person = new Person();
        person.setFirstName("supriadi");
        person.setLastName("yusuf");

        Address address = new Address();
        person.setAddress(address);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(3,violations.size());

        violations.forEach(violation -> {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("==========================");
        });
    }
}

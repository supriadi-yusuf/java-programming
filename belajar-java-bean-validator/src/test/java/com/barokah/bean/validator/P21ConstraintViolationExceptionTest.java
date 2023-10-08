package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.Set;

//https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintviolationexception
public class P21ConstraintViolationExceptionTest extends AbstractValidatorTest{
    @Test
    void testException(){
        Person person = new Person();
        person.setFirstName("adi");
        person.setLastName("yusuf");

        person.setAddress(new Address());
        person.getAddress().setCity("cirebon");
        person.getAddress().setStreet("jalan mahoni");
        person.getAddress().setCountry("indonesia");

        Validator validator = getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }
}

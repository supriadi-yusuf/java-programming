package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class P18ConstraintDescriptorTest extends AbstractValidatorTest{

    @Test
    void testConstraintDescriptor(){
        Person person = new Person();

        Validator validator = getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (var violation : violations ){
            ConstraintDescriptor<?> descriptor = violation.getConstraintDescriptor();

            System.out.println(descriptor.getAnnotation());
            System.out.println(descriptor.getAttributes());
            System.out.println(descriptor.getPayload());
            System.out.println(descriptor.getGroups());

            System.out.println("======================");
        }
    }
}

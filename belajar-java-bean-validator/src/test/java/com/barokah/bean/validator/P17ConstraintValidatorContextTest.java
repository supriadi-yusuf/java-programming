package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class P17ConstraintValidatorContextTest extends AbstractValidatorTest{

    @Test
    void testConstraintValidatorContext(){

        RegisterWithContext register = new RegisterWithContext();
        register.setUserName("supriadi");
        register.setPassword("pwd");
        register.setRetypePassword("pwd1");

        Validator validator = getValidator();
        Set<ConstraintViolation<RegisterWithContext>> violations = validator.validate(register);
        for (var violation : violations){
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getPropertyPath()); // this is not empty after we change context implementation in validator
            System.out.println(violation.getMessage());
            System.out.println("=======================");
        }

    }
}

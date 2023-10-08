package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class P15ClassLevelConstraintTest extends AbstractValidatorTest{
    @Test
    void testClassLevel(){
        Register register = new Register();

        register.setUserName("supriadi");
        register.setPassword("pwd");
        register.setRetypePassword("pwd1");

        Validator validator = getValidator();
        Set<ConstraintViolation<Register>> violations = validator.validate(register);
        for (var violation : violations){
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getPropertyPath()); // this is empty
            System.out.println(violation.getMessage());
            System.out.println("=======================");
        }

    }
}

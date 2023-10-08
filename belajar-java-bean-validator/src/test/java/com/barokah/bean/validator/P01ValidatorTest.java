package com.barokah.bean.validator;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01ValidatorTest {

    @Test
    void testCreateValidator(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Assertions.assertNotNull(validator);

        validatorFactory.close();
    }
}

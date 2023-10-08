package com.barokah.bean.validator.validators;

import com.barokah.bean.validator.Register;
import com.barokah.bean.validator.RegisterWithContext;
import com.barokah.bean.validator.annotatons.CheckPassword;
import com.barokah.bean.validator.annotatons.CheckPasswordWithContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class CheckPasswordWithContextValidator implements ConstraintValidator<CheckPasswordWithContext, RegisterWithContext> {

    private String message;

    @Override
    public void initialize(CheckPasswordWithContext constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(RegisterWithContext value, ConstraintValidatorContext context) {
        boolean equals = Objects.equals(value.getPassword(), value.getRetypePassword());
        if (!equals){
            // change context implementation
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("password")
                    .addConstraintViolation();

            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("retype password")
                    .addConstraintViolation();
        }

        return equals;
    }
}

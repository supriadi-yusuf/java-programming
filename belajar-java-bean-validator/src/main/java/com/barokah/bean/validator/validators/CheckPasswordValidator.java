package com.barokah.bean.validator.validators;

import com.barokah.bean.validator.Register;
import com.barokah.bean.validator.annotatons.CheckPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {
    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        return Objects.equals( value.getPassword(),value.getRetypePassword());
    }
}

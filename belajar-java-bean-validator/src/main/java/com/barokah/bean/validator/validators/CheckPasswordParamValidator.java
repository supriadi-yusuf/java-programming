package com.barokah.bean.validator.validators;

import com.barokah.bean.validator.annotatons.CheckPasswordParam;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget({ValidationTarget.PARAMETERS})
public class CheckPasswordParamValidator implements ConstraintValidator<CheckPasswordParam,Object[]> {
    private int passwordPosition;
    private int retypePasswordPosition;

    @Override
    public void initialize(CheckPasswordParam constraintAnnotation) {
        passwordPosition=constraintAnnotation.passwordPosition();
        retypePasswordPosition=constraintAnnotation.retypePasswordPosition();
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        String password = (String) value[passwordPosition];
        String retypePassword = (String) value[retypePasswordPosition];

        if (password==null || retypePassword==null){
            return true;// skip, let others do it
        }

        return password.equals(retypePassword);
    }
}

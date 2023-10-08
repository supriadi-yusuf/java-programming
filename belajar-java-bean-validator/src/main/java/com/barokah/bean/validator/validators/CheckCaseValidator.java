package com.barokah.bean.validator.validators;

import com.barokah.bean.validator.annotatons.CheckCase;
import com.barokah.bean.validator.enums.CaseMode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (caseMode == CaseMode.LOWER) {
            return value.equals(value.toLowerCase());
        } else {
            return value.equals(value.toUpperCase());
        }
    }
}

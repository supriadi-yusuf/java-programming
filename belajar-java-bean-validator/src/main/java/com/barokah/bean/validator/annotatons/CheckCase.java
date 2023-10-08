package com.barokah.bean.validator.annotatons;

import com.barokah.bean.validator.enums.CaseMode;
import com.barokah.bean.validator.validators.CheckCaseValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {
    CaseMode mode() default CaseMode.LOWER;

    String message() default "invalid value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

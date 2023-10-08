package com.barokah.bean.validator.annotatons;

import com.barokah.bean.validator.validators.CheckPasswordParamValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordParamValidator.class})
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParam {
    int passwordPosition();
    int retypePasswordPosition();
    String message() default "Password does not match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

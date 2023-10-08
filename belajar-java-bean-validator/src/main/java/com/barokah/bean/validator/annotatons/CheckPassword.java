package com.barokah.bean.validator.annotatons;

import com.barokah.bean.validator.validators.CheckPasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPassword {
    String message() default "password does not match";
    Class<?>[] groups() default {};
    Class<?extends Payload>[] payload() default {};
}

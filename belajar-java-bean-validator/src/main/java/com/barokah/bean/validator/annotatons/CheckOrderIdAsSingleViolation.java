package com.barokah.bean.validator.annotatons;

import com.barokah.bean.validator.enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@NotBlank(message = "order id must not blank")
@Size(min = 1, max = 10,message = "order id must contain 1 to 10 characters")
@CheckCase(mode = CaseMode.LOWER, message = "order id must be lower case")
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderIdAsSingleViolation {
    String message() default "invalid value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

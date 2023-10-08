package com.s17.reflection.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface NotBlank {
    boolean allowEmptyString() default false;
}

package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class P16CrossParameterConstraintTest extends AbstractValidatorTest {

    @Test
    void testCrossParameter() throws NoSuchMethodException {
        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);

        ExecutableValidator executableValidator = getExecutableValidator();
        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, method, new Object[]{"user", "pw", "pwd"});
        for (var violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getMessage());
            System.out.println("========================");
        }

    }

}

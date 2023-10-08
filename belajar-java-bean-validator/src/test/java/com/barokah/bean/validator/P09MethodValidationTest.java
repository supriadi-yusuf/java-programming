package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class P09MethodValidationTest extends AbstractValidatorTest {

    @Test
    void testMethodSayHello() throws NoSuchMethodException {
        Person person = new Person();

        Method method = Person.class.getDeclaredMethod("sayHello", String.class);

        String name = "";
        ExecutableValidator executableValidator = getExecutableValidator();

        // validate input parameters
        Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, method, new Object[]{name});
        for (var violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=========================");
        }
    }

    @Test
    void testMethodFullName() throws NoSuchMethodException {

        Person person = new Person("","");

        Method method = Person.class.getDeclaredMethod("fullName");

        ExecutableValidator executableValidator = getExecutableValidator();

        String fullName = person.fullName();
        Set<ConstraintViolation<Person>> violations = executableValidator.validateReturnValue(person, method, fullName);
        for (var violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }

    }
}

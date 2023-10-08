package com.barokah.bean.validator;

import com.barokah.bean.validator.payload.EmailErrorlPayload;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class  AbstractValidatorTest {
    private ValidatorFactory validatorFactory;
    private Validator validator;
    private ExecutableValidator executableValidator;
    private MessageInterpolator messageInterpolator;

    public Validator getValidator() {
        return validator;
    }

    public ExecutableValidator getExecutableValidator() {
        return executableValidator;
    }

    public MessageInterpolator getMessageInterpolator() {
        return messageInterpolator;
    }

    @BeforeEach
    void setUp(){
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown(){
        validatorFactory.close();// it is mandatory to close validator factory if it is not used any more
    }

    void validateWithoutGroup(Object object){
        // to validate object we have to mention groups as argument.  But if we do not mention groups so
        // jakarta.validation.groups.Default.class will be used as group by default
        Set<ConstraintViolation<Object>> violations = validator.validate(object/*,jakarta.validation.groups.Default.class*/);
        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============================");
        });
    }

    void validateWithGroup(Object object, Class<?>... groups){
        // to validate object we have to mention groups where object is classified in.
        Set<ConstraintViolation<Object>> violations = validator.validate(object, groups);
        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============================");
        });
    }

    void validateWithGroupAndPayload(Object object, Class<?>... groups){
        // to validate object we have to mention groups where object is classified in.
        Set<ConstraintViolation<Object>> violations = validator.validate(object, groups);
        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

            Set<Class<? extends Payload>> payloads = violation.getConstraintDescriptor().getPayload();
            for (var payload : payloads){
                if (payload == EmailErrorlPayload.class){
                    new EmailErrorlPayload().sendEmail(violation);
                }
            }

            System.out.println("===============================");
        });
    }
}

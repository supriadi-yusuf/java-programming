package com.barokah.bean.validator.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailErrorlPayload implements Payload {
    public void sendEmail(ConstraintViolation<?> violation){
        System.out.println("Send email because error : " + violation.getMessage());
    }
}

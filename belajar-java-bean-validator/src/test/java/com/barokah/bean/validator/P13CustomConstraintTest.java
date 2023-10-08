package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class P13CustomConstraintTest extends AbstractValidatorTest{

    @Test
    void testCustomConstraint(){
        PaymentWithCustomConstraint payment = new PaymentWithCustomConstraint();
        payment.setOrderId("A12iiiiiiiiiii3");

        validateWithoutGroup(payment);
    }
}

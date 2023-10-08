package com.barokah.bean.validator;

import org.junit.jupiter.api.Test;

public class P14ConstraintCompositionTest extends AbstractValidatorTest{

    @Test
    void testComposition(){
        PaymentWithConstraintComposition payment = new PaymentWithConstraintComposition();
        payment.setOrderId("A12iiiiiiiiiii3");

        validateWithoutGroup(payment);

    }

    @Test
    void testCompositionReportAsSingle(){
        PaymentWithConstraintCompositionAsSingle payment = new PaymentWithConstraintCompositionAsSingle();
        payment.setOrderId("A12iiiiiiiiiii3");

        validateWithoutGroup(payment);

    }
}

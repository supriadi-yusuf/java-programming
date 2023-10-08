package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

/*
Message interpolation is process of creating error message.
{ and } are special character

 */
public class P11MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {
        PaymentWithInterpolation payment = new PaymentWithInterpolation();
        payment.setOrderId("");
        payment.setAmount(10L);

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }
}

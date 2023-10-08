package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class P08PayloadTest extends AbstractValidatorTest {
    @Test
    void payloadTest(){
        var payment = new PaymentWithGroupAndPayload();
        payment.setOrderId("0001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111");

        validateWithGroupAndPayload(payment, CreditCardPaymentGroup.class);
    }
}

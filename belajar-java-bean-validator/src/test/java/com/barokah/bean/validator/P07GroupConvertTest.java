package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class P07GroupConvertTest extends AbstractValidatorTest {

    @Test
    void testGroupConvert() {
        PaymentWithConvertGroup payment = new PaymentWithConvertGroup();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer());

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }
}

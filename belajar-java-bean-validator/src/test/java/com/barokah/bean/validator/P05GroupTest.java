package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import com.barokah.bean.validator.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class P05GroupTest extends AbstractValidatorTest {
    // validation can be grouped

    @Test
    void testCreditCardGroup(){
        PaymentWithGroup payment = new PaymentWithGroup();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("1234");

        validateWithGroup(payment,CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccountGroup(){
        PaymentWithGroup payment = new PaymentWithGroup();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setVirtualAccount("");

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
    }
}

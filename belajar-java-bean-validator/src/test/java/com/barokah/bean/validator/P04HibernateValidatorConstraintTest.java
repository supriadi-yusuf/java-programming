package com.barokah.bean.validator;

import org.junit.jupiter.api.Test;

public class P04HibernateValidatorConstraintTest extends AbstractValidatorTest {
   /* Hibernate validator constraint
    https://docs.jboss.org/hibernate/validator/5.1/api/org/hibernate/validator/constraints/package-summary.html*/

    @Test
    void testHibernateValidatorConstraintInvalid() {
        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(1_000L);
        payment.setCreditCard("123");

        validateWithoutGroup(payment);
    }

    @Test
    void testHibernateValidatorConstraintValid() {
        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(1_000_000L);
        payment.setCreditCard("4111111111111111");

        validateWithoutGroup(payment);
    }
}

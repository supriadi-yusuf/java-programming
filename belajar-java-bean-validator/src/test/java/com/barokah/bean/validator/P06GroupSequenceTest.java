package com.barokah.bean.validator;

import com.barokah.bean.validator.group.PaymentGroup;
import org.junit.jupiter.api.Test;

// we can determine which test group should be run first, second, etc
// if previous group error, remaining group will be skipped / ignored
public class P06GroupSequenceTest extends AbstractValidatorTest {

    @Test
    void testGroupSequence() {
        PaymentWithGroup payment = new PaymentWithGroup();

        validateWithGroup(payment, PaymentGroup.class);
    }
}

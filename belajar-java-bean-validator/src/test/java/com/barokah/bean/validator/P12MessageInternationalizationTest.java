package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.Validator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class P12MessageInternationalizationTest extends AbstractValidatorTest {

    @Test
    void testChangeLocal() {
        Locale.setDefault(new Locale("id", "ID"));

        PaymentWithInterpolation payment = new PaymentWithInterpolation();
        payment.setOrderId("");
        payment.setAmount(10L);

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {

        PaymentWithInterpolation payment = new PaymentWithInterpolation();
        payment.setOrderId("");
        payment.setAmount(10L);

        Locale locale = new Locale("id", "ID");
        MessageInterpolator messageInterpolator = getMessageInterpolator();
        Validator validator = getValidator();

        Set<ConstraintViolation<PaymentWithInterpolation>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (var violation : violations) {
            String messageTemplate = violation.getMessageTemplate();
            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(),violation.getInvalidValue(),violation.getRootBeanClass(),
                    violation.getPropertyPath(),violation.getConstraintDescriptor().getAttributes(),violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES,true);
            String errorMessage = messageInterpolator.interpolate(messageTemplate, context, locale);

            System.out.println(errorMessage);
            System.out.println("=======================");
        }

    }

}

package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import com.barokah.bean.validator.group.VirtualAccountPaymentGroup;
import com.barokah.bean.validator.payload.EmailErrorlPayload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class PaymentWithGroupAndPayload {
    @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "order id must not blank")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "amount must not null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 10_000L, max = 100_000_000L, message = "amount must between 10000 and 1000000")
    private Long amount;
    @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card must not blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "credit card must valid number", payload = EmailErrorlPayload.class) // atau    @CreditCardNumber
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account must not blank")
    private String virtualAccount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}

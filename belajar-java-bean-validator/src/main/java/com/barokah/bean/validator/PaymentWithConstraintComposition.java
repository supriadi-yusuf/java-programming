package com.barokah.bean.validator;

import com.barokah.bean.validator.annotatons.CheckCase;
import com.barokah.bean.validator.annotatons.CheckOrderId;
import com.barokah.bean.validator.enums.CaseMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class PaymentWithConstraintComposition {
    @CheckOrderId
    private String orderId;

    @NotNull(message = "amount must not null")
    @Range(min = 10_000L, max = 100_000_000L, message = "amount must between 10000 and 1000000")
    private Long amount;
    @NotBlank(message = "credit card must not blank")
    @LuhnCheck(message = "credit card must valid number") // atau    @CreditCardNumber
    private String creditCard;

    @NotBlank(message = "virtual account must not blank")
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

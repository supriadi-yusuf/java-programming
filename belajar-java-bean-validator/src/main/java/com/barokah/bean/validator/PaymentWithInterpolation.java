package com.barokah.bean.validator;

import com.barokah.bean.validator.group.CreditCardPaymentGroup;
import com.barokah.bean.validator.group.VirtualAccountPaymentGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class PaymentWithInterpolation {
    @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "order id must not blank")
    @Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 1, max = 10,
            message = "order id must between {min} and {max} characters")
    // min and max should be method in this constraint
    private String orderId;

    // better alternative is to put error message in file ValidationMessages.properties then we only use key
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{payment_with_interpolation.amount.not_blank}")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 10_000L, max = 100_000_000L,
            message = "{payment_with_interpolation.amount.range}")
    private Long amount;
    @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "{payment_with_interpolation.credit_card.not_blank}")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "{payment_with_interpolation.credit_card.luhn_check}")
    // atau    @CreditCardNumber
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account must not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "customer must not null")
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

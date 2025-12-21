package com.conceptcoding.interviewquestions.parkinglot.payment;

import com.conceptcoding.interviewquestions.parkinglot.enums.PaymentMode;

public class PaymentFactory {
    public static Payment getPaymentInstance(PaymentMode paymentType, double amountToPay) {
        return switch (paymentType) {
            case CASH -> new CashPayment(amountToPay);
            case UPI -> new UPIPayment(amountToPay);
            case CREDIT_CARD -> new CreditCardPayment(amountToPay);
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
    }
}

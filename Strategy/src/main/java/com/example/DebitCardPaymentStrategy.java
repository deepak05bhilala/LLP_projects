package com.example;

public class DebitCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void executePayment(Integer amount) {
        System.out.println("DebitCardPayment="+amount);
    }
}

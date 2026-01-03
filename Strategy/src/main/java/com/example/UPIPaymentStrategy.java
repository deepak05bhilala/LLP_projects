package com.example;

public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public void executePayment(Integer amount) {
        System.out.println("UpiPayment="+amount);
    }
}

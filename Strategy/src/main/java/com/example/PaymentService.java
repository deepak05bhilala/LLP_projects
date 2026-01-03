package com.example;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class PaymentService {
    PaymentStrategy paymentStrategy;

    void executePayment(Integer amount){
        paymentStrategy.executePayment(amount);
    }
}

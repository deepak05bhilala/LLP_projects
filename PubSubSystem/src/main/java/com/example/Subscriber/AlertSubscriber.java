package com.example.Subscriber;

import com.example.Message.Message;
import lombok.Data;

@Data
public class AlertSubscriber implements Subscriber{
    private final String id;

    @Override
    public void onMessage(Message message) {
        System.out.printf("[Subscriber %s] received message '%s'%n", id, message.getPayload());
    }
}

package com.example.Subscriber;

import com.example.Message.Message;
import lombok.Data;

@Data
public class NewsSubscriber implements Subscriber{
    private final String id;

    @Override
    public void onMessage(Message message) {
        System.out.printf("!!! [ALERT - %s] : '%s' !!!%n", id, message.getPayload());
    }
}

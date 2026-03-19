package com.example.Subscriber;

import com.example.Message.Message;

public interface Subscriber {
    void onMessage(Message message);
    String getId();
}

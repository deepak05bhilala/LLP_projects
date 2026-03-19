package com.example.Message;

import lombok.Data;

import java.time.Instant;

@Data
public class Message {
    private final String payload;
    private final Instant timestamp;

    public Message(String payload) {
        this.payload = payload;
        this.timestamp = Instant.now();
    }
    @Override
    public String toString() {
        return "Message{" + "payload='" + payload + '\'' + '}';
    }
}

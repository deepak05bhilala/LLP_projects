package com.example.User;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private final String id;
    private final String name;
    private final AtomicInteger reputation;

    public void updateReputation(int change) {
        this.reputation.addAndGet(change);
    }

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.reputation = new AtomicInteger(0);
    }

}

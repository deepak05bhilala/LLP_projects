package com.example.User;

import lombok.Getter;

import java.util.UUID;

@Getter
public class User {
    private final String id;
    private final String name;
    private final String email;

    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }
}

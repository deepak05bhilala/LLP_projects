package com.example.Content;

import com.example.User.User;

import java.util.UUID;

class Comment extends Content {
    public Comment(String body, User author) {
        super(UUID.randomUUID().toString(), body, author);
    }
}
package com.example.Comment;

import com.example.User.User;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Comment {
    private final String id;
    private final String content;
    private final User author;
    private final Date timestamp;

    public Comment(String content, User author) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.timestamp = new Date();
    }
}

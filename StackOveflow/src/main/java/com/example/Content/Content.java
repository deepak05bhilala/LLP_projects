package com.example.Content;


import com.example.User.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
abstract class Content {
    protected final String id;
    protected final String body;
    protected final User author;
    protected final LocalDateTime creationTime;

    public Content(String id, String body, User author) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.creationTime = LocalDateTime.now();
    }
}
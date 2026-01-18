package com.example.Content;

import com.example.User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Answer extends Post {
    private boolean isAccepted = false;

    public Answer(String body, User author) {
        super(UUID.randomUUID().toString(), body, author);
    }
}
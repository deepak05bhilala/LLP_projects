package com.example.Event;

import com.example.Content.Post;
import com.example.Enum.EventType;
import com.example.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Event {
    private final EventType type;
    private final User actor;        // user who performed the action
    private final Post targetPost;   // post being acted on
}

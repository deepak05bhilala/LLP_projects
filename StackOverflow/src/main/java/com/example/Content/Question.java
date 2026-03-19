package com.example.Content;

import com.example.Enum.EventType;
import com.example.Event.Event;
import com.example.Tag.Tag;
import com.example.User.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
public class Question extends Post {
    private final String title;
    private final Set<Tag> tags;
    private final List<Answer> answers = new ArrayList<>();
    private Answer acceptedAnswer;

    public Question(String title, String body, User author, Set<Tag> tags) {
        super(UUID.randomUUID().toString(), body, author);
        this.title = title;
        this.tags = tags;
    }

    public void addAnswer(Answer answer) { this.answers.add(answer); }

    //TODO :Remember usage of observerPattern
    public synchronized void acceptAnswer(Answer answer) {
        if (!this.author.getId().equals(answer.getAuthor().getId()) && this.acceptedAnswer == null) {
            this.acceptedAnswer = answer;
            answer.setAccepted(true);
            notifyObservers(new Event(EventType.ACCEPT_ANSWER, answer.getAuthor(), answer));
        }
    }
}

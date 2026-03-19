package com.example.SearchStrategy;

import com.example.Content.Question;
import com.example.User.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserSearchStrategy implements SearchStrategy {
    private final User user;

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getAuthor().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }
}

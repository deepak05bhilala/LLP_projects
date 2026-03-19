package com.example.SearchStrategy;

import com.example.Content.Question;
import com.example.Tag.Tag;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TagSearchStrategy implements SearchStrategy {
    private final Tag tag;

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getTags().stream()
                        .anyMatch(t -> t.getName().equalsIgnoreCase(tag.getName())))
                .collect(Collectors.toList());
    }
}

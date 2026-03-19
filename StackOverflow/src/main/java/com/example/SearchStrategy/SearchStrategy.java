package com.example.SearchStrategy;

import com.example.Content.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}

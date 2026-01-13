package com.example.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Symbol {
    // REVISE: How to initialise an enum class
    X('X'),
    O('O'),
    Empty('_');

    private final char symbol;
}

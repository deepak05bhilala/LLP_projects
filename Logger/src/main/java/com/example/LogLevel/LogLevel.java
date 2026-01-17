package com.example.LogLevel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LogLevel {
    DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);
    private final Integer level;
    public boolean isGreaterOrEqual(LogLevel other){
        return this.level>= other.level;
    }
}

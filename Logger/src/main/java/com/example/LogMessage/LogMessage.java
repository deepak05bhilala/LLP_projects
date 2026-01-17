package com.example.LogMessage;

import com.example.LogLevel.LogLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public final class LogMessage {
    private final LogLevel level;
    private final String loggerName;
    private final String message;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    @Builder.Default
    private String threadName = Thread.currentThread().getName();

}

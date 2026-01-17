package com.example.LogFormatterStrategy;

import com.example.LogMessage.LogMessage;

public interface LogFormatterStrategy {
    String format(LogMessage logMessage);
}

package com.example.LogAppenderStrategy;

import com.example.LogFormatterStrategy.LogFormatterStrategy;
import com.example.LogMessage.LogMessage;

public interface LogAppenderStrategy {
    void append(LogMessage logMessage);
    void close();
    LogFormatterStrategy getFormatter();
    void setFormatter(LogFormatterStrategy formatter);

}

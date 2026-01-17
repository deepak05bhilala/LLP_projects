package com.example.LogAppenderStrategy;

import com.example.LogFormatterStrategy.LogFormatterStrategy;
import com.example.LogFormatterStrategy.SimpleTextFormatter;
import com.example.LogMessage.LogMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsoleAppender implements LogAppenderStrategy{
    private LogFormatterStrategy formatter;

    public ConsoleAppender() {
        this.formatter = new SimpleTextFormatter();
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }

    @Override
    public void close() {}

}

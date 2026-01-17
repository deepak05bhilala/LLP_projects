package com.example.Logger;

import com.example.LogAppenderStrategy.LogAppenderStrategy;
import com.example.LogLevel.LogLevel;
import com.example.LogManager.LogManager;
import com.example.LogMessage.LogMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public class Logger {
    private final String name;
    private LogLevel level;
    private final Logger parent;
    private final List<LogAppenderStrategy> appenders;
    private boolean additivity = true;

    public Logger(String name, Logger parent) {
        this.name = name;
        this.parent = parent;
        //TODO: Learn about CopyOnWriteArrayList
        this.appenders = new CopyOnWriteArrayList<>();
    }

    public void addAppender(LogAppenderStrategy appender) {
        appenders.add(appender);
    }
    //TODO: Need to memorise this logic
    public LogLevel getEffectiveLevel() {
        for (Logger logger = this; logger != null; logger = logger.parent) {
            LogLevel currentLevel = logger.level;
            if (currentLevel != null) {
                return currentLevel;
            }
        }
        return LogLevel.DEBUG; // Default root level
    }
    //TODO: Need to memorise this logic
    public void log(LogLevel messageLevel, String message) {
        if (messageLevel.isGreaterOrEqual(getEffectiveLevel())) {
            LogMessage logMessage = LogMessage.builder()
                    .message(message)
                    .level(messageLevel)
                    .loggerName(this.name)
                    .build();
            callAppenders(logMessage);
        }
    }
    //TODO: Need to memorise this logic
    private void callAppenders(LogMessage logMessage) {
        if (!appenders.isEmpty()) {
            LogManager.getInstance().getProcessor().process(logMessage, this.appenders);
        }
        if (additivity && parent != null) {
            parent.callAppenders(logMessage);
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}

package com.example.LogAppenderStrategy;

import com.example.LogFormatterStrategy.LogFormatterStrategy;
import com.example.LogFormatterStrategy.SimpleTextFormatter;
import com.example.LogMessage.LogMessage;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;

@Getter
@Setter
class FileAppender implements LogAppenderStrategy {
    private FileWriter writer;
    private LogFormatterStrategy formatter;

    public FileAppender(String filePath) {
        this.formatter = new SimpleTextFormatter();
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (Exception e) {
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }
    }

    @Override
    public synchronized void append(LogMessage logMessage) {
        try {
            writer.write(formatter.format(logMessage) + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to close logs file, exception: " + e.getMessage());
        }
    }

}

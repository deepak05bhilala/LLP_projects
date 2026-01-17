package com.example;

import com.example.LogAppenderStrategy.LogAppenderStrategy;
import com.example.LogMessage.LogMessage;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncLogProcessor {
    //TODO: Memorise the code related to executor service
    private final ExecutorService executor;

    public AsyncLogProcessor() {
        this.executor = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "AsyncLogProcessor");
            thread.setDaemon(true); // Don't prevent JVM exit
            return thread;
        });
    }

    public void process(LogMessage logMessage, List<LogAppenderStrategy> appenders) {
        if (executor.isShutdown()) {
            System.err.println("Logger is shut down. Cannot process log message.");
            return;
        }

        // Submit a new task to the executor.
        executor.submit(() -> {
            for (LogAppenderStrategy appender : appenders) {
                appender.append(logMessage);
            }
        });
    }

    public void stop() {
        // Disable new tasks from being submitted
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.err.println("Logger executor did not terminate in the specified time.");
                // Forcibly shut down any still-running tasks.
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}


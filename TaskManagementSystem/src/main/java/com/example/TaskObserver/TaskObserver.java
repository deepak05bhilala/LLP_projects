package com.example.TaskObserver;

import com.example.Task.Task;

public interface TaskObserver {
    void update(Task task, String changeType);
}

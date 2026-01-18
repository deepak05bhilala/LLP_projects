package com.example.TaskState;

import com.example.Enum.TaskStatus;
import com.example.Task.Task;

public interface TaskState {
    void startProgress(Task task);
    void completeTask(Task task);
    void reopenTask(Task task);
    TaskStatus getStatus();
}

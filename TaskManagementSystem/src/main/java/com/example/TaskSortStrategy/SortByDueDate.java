package com.example.TaskSortStrategy;

import com.example.Task.Task;

import java.util.Comparator;
import java.util.List;

public class SortByDueDate implements TaskSortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }
}

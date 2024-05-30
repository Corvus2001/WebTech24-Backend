package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTask(int id) {
        Optional<Task> task = tasks.stream().filter(t -> t.getId() == id).findFirst();
        return task.orElse(null);
    }

    public Task createTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Task updateTask(int id, Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.set(i, task);
                return task;
            }
        }
        return null;
    }

    public void deleteTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}

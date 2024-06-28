package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(int id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(int id, Task task) {
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        logger.info("Existing Task: {}", existingTask);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDone(task.isDone());
        existingTask.setDueDate(task.getDueDate());
        logger.info("Updated Task: {}", existingTask);
        return taskRepository.save(existingTask);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public List<Task> filterTasks(String status) {
        if ("completed".equalsIgnoreCase(status)) {
            return taskRepository.findByDone(true);
        } else if ("pending".equalsIgnoreCase(status)) {
            return taskRepository.findByDone(false);
        } else {
            return taskRepository.findAll();
        }
    }
}

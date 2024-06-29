package com.example.demo;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks") // Ensure the base URL is correct
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return tasks.stream()
                .map(task -> new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.isDone(), task.getDueDate()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable int id) {
        Task task = taskService.getTask(id);
        return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.isDone(), task.getDueDate());
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDone(taskRequest.isDone());
        task.setDueDate(taskRequest.getDueDate());
        Task createdTask = taskService.createTask(task);
        return new TaskResponse(createdTask.getId(), createdTask.getTitle(), createdTask.getDescription(), createdTask.isDone(), createdTask.getDueDate());
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable int id, @RequestBody TaskRequest taskRequest) {
        Task task = taskService.getTask(id);
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDone(taskRequest.isDone());
        task.setDueDate(taskRequest.getDueDate());
        Task updatedTask = taskService.updateTask(id, task);
        return new TaskResponse(updatedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(), updatedTask.isDone(), updatedTask.getDueDate());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/filter")
    public List<TaskResponse> filterTasks(@RequestParam("status") String status) {
        List<Task> tasks = taskService.filterTasks(status);
        return tasks.stream()
                .map(task -> new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.isDone(), task.getDueDate()))
                .collect(Collectors.toList());
    }
}

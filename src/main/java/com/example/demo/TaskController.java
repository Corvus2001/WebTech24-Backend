/* package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    // Assuming you have a TaskService class for handling operations related to tasks
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home() {
        return "Wenn du das ließt, funktioniert das Backend!";
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getTask(id);
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}

package com.example.demo;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home() {
        return "Wenn du das ließt, funktioniert das Backend!";
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
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDone(taskRequest.isDone());
        task.setDueDate(taskRequest.getDueDate());
        Task updatedTask = taskService.updateTask(id, task);
        return new TaskResponse(updatedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(), updatedTask.isDone(), updatedTask.getDueDate());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
*/
package com.example.demo;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks") // Stellen Sie sicher, dass die Basis-URL korrekt ist
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

    PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable int id, @RequestBody TaskRequest taskRequest) {
        // Retrieve the existing task
        Task task = taskService.getTask(id);

        // Update the task with new values from the request
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDone(taskRequest.isDone());
        task.setDueDate(taskRequest.getDueDate());

        // Save the updated task back to the database
        Task updatedTask = taskService.updateTask(id, task);

        // Return the updated task details as a response
        return new TaskResponse(updatedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(), updatedTask.isDone(), updatedTask.getDueDate());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}



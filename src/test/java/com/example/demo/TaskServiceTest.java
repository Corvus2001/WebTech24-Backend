package com.example.demo;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import com.example.demo.Task;
import com.example.demo.TaskRepository;
import com.example.demo.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Title1", "Description1", false, new Date()));
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();
        assertEquals(1, result.size());
    }

    @Test
    public void testGetTask() {
        Task task = new Task("Title", "Description", false, new Date());
        when(taskRepository.findById(1)).thenReturn(Optional.of(task));

        Task result = taskService.getTask(1);
        assertNotNull(result);
        assertEquals("Title", result.getTitle());
    }

    @Test
    public void testCreateTask() {
        Task task = new Task("Title", "Description", false, new Date());
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task result = taskService.createTask(task);
        assertNotNull(result);
        assertEquals("Title", result.getTitle());
    }

    @Test
    public void testUpdateTask() {
        Task existingTask = new Task("Title", "Description", false, new Date());
        when(taskRepository.findById(1)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(any(Task.class))).thenReturn(existingTask);

        Task updatedTask = new Task("Updated Title", "Updated Description", true, new Date());
        Task result = taskService.updateTask(1, updatedTask);

        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
    }

    @Test
    public void testDeleteTask() {
        doNothing().when(taskRepository).deleteById(1);

        taskService.deleteTask(1);
        verify(taskRepository, times(1)).deleteById(1);
    }
}

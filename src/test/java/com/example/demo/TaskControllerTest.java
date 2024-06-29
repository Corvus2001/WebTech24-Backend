package com.example.demo;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TaskControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void testGetAllTasks() throws Exception {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Title1", "Description1", false, new Date()));
        when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title1"));
    }

    @Test
    public void testGetTask() throws Exception {
        Task task = new Task("Title", "Description", false, new Date());
        when(taskService.getTask(1)).thenReturn(task);

        mockMvc.perform(get("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title"));
    }


    @Test
    public void testCreateTask() throws Exception {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTitle("Title");
        taskRequest.setDescription("Description");
        taskRequest.setDone(false);
        taskRequest.setDueDate(new Date());

        Task task = new Task("Title", "Description", false, new Date());
        task.setId(1);  // Task id ayarlanarak döndürülecek Task nesnesi oluşturuluyor
        when(taskService.createTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Title\", \"description\": \"Description\", \"done\": false, \"dueDate\": \"2024-06-29\"}"))
                .andExpect(status().isOk())  // Beklenen durum kodunu 200 olarak değiştiriyoruz
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.description").value("Description"))
                .andExpect(jsonPath("$.done").value(false))
                .andExpect(jsonPath("$.dueDate").value("2024-06-29"));
    }


    @Test
    public void testUpdateTask() throws Exception {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTitle("Updated Title");
        taskRequest.setDescription("Updated Description");
        taskRequest.setDone(true);
        taskRequest.setDueDate(new Date());

        Task existingTask = new Task("Old Title", "Old Description", false, new Date());
        when(taskService.getTask(1)).thenReturn(existingTask);

        Task updatedTask = new Task("Updated Title", "Updated Description", true, new Date());
        when(taskService.updateTask(eq(1), any(Task.class))).thenReturn(updatedTask);

        mockMvc.perform(put("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Updated Title\", \"description\": \"Updated Description\", \"done\": true, \"dueDate\": \"2024-06-29\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteTask() throws Exception {
        doNothing().when(taskService).deleteTask(1);

        mockMvc.perform(delete("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(taskService, times(1)).deleteTask(1);
    }
}

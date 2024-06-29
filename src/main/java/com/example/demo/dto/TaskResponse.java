package com.example.demo.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskResponse {
    private int id;
    private String title;
    private String description;
    private boolean done;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dueDate;

    public TaskResponse(int id, String title, String description, boolean done, Date dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }

    // Getter ve Setter metodları

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

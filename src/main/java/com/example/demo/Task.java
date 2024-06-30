package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private boolean done;
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public Task() {}

    public Task(String title, String description, boolean done, Date dueDate) {
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







//ignor this
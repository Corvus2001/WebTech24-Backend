package com.example.demo;


import java.util.Date;

public class Task{
    private int id;
    private String title;
    private String description;
    private boolean done;
    private Date dueDate;

    // Constructor
    public Task(int id, String title, String description, boolean done, Date dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for status
    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // Getter and Setter for dueDate
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    // Method to update the status of the task
    public void updateDueDate(boolean newDone) {
        setDone(newDone);
    }

    // Override toString method for easy printing of task details
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + done + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}

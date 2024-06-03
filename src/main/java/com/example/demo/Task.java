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

    // Standardkonstruktor
    public Task() {}

    // Konstruktor mit Parametern
    public Task(int id, String title, String description, boolean done, Date dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }

    // Getter und Setter für id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter und Setter für title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter und Setter für description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter und Setter für done
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // Getter und Setter für dueDate
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    // Methode zum Aktualisieren des Status der Aufgabe
    public void updateDueDate(boolean newDone) {
        setDone(newDone);
    }

    // Überschreibe die toString-Methode für eine einfache Ausgabe der Aufgabendetails
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", dueDate=" + dueDate +
                '}';
    }
}

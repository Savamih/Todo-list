package ru.savam.todolist.model;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


public class Task {

    private int task_id;
    private String description;
    private Time due_time;
    private Boolean isWasted;
    private Boolean isDone;

    public Task() {
    }

    public Task(String description, Time due_time, Boolean isWasted, Boolean isDone) {
        this.description = description;
        this.due_time = due_time;
        this.isWasted = isWasted;
        this.isDone = isDone;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getDue_time() {
        return due_time;
    }

    public void setDue_time(Time due_time) {
        this.due_time = due_time;
    }

    public Boolean getWasted() {
        return isWasted;
    }

    public void setWasted(Boolean wasted) {
        isWasted = wasted;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}

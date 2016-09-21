package ru.savam.todolist.model;


import java.util.Date;


public class Task {

    private int task_id;
    private String description;
    private Date create_date;
    private Date due_date;
    private Boolean done;

    public Task(){

    }

    public Task(String description, Date create_date, Date due_date, Boolean done) {
        this.description = description;
        this.create_date = create_date;
        this.due_date = due_date;
        this.done = done;
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}

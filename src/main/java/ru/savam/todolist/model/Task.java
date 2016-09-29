package ru.savam.todolist.model;




import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

public class Task {

    private int task_id;
    @NotNull(message = "Description shouldn't be empty")
    private String description;
    @NotNull(message = "Time shouldn't be empty")
    private Timestamp due_time;
    private Boolean isWasted;
    private Boolean isDone;

    public Task() {
    }

    public Task(int task_id, String description, Timestamp due_time, Boolean isWasted, Boolean isDone) {
        this.task_id = task_id;
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

    public Timestamp getDue_time() {
        return due_time;
    }

    public void setDue_time(Timestamp due_time) {
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

package ru.savam.todolist.dao;


import org.springframework.stereotype.Component;
import ru.savam.todolist.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskSetter {

    Task taskSet(ResultSet rs) throws SQLException {

        Task task = new Task();

        task.setTask_id(rs.getInt("task_id"));
        task.setDescription(rs.getString("description"));
        task.setDue_time(rs.getTimestamp("due_time"));
        task.setWasted(rs.getBoolean("iswasted"));
        task.setDone(rs.getBoolean("isdone"));

        return task;
    }
}

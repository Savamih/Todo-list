package ru.savam.todolist.dao;

import ru.savam.todolist.model.Task;

import java.util.List;

public interface TaskDAO {

    public void saveOrUpdate(Task task);

    public void delete(int taskId);

    public Task get(int taskId);

    public List<Task> list();
}

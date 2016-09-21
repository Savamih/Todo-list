package ru.savam.todolist.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savam.todolist.dao.TaskDAO;
import ru.savam.todolist.model.Task;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TaskDAO taskDAO;


    @Override
    public void saveOrUpdate(Task task) {
        taskDAO.saveOrUpdate(task);
    }

    @Override
    public void delete(int taskId) {
        taskDAO.delete(taskId);
    }

    @Override
    public Task get(int taskId) {
        return taskDAO.get(taskId);
    }

    @Override
    public List<Task> list() {
        return taskDAO.list();
    }
}

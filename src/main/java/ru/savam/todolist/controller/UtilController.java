package ru.savam.todolist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.savam.todolist.model.Task;
import ru.savam.todolist.service.TodoService;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/done")
public class UtilController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value= "/done/{id}", method = RequestMethod.GET)
    public @ResponseBody Task changeIsDone(@PathVariable(value = "id") int task_id) {
        Task task = todoService.get(task_id);
        task.setDone(!todoService.get(task_id).getDone());
        todoService.saveOrUpdate(task);

        return task;
    }


}

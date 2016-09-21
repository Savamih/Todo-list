package ru.savam.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.savam.todolist.dao.TaskDAO;
import ru.savam.todolist.model.Task;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TaskDAO taskDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listTask(Model model){
        List<Task> listTask = taskDAO.list();
        model.addAttribute("listTask", listTask);

        return "tasklist";
    }

}

package ru.savam.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.savam.todolist.model.Task;
import ru.savam.todolist.service.TodoService;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TodoService todoService;

    @InitBinder
    public void binder(WebDataBinder binder) {binder.registerCustomEditor(Time.class,
            new PropertyEditorSupport() {
                public void setAsText(String value) {
                    try {
                        Date parsedDate = new SimpleDateFormat("HH:mm").parse(value);
                        setValue(new Time(parsedDate.getTime()));
                    } catch (ParseException e) {
                        setValue(null);
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    @RequestMapping(value = "todo/list", method = RequestMethod.GET)
    public String listTask(Model model){
        List<Task> listTask = todoService.list();
        model.addAttribute("listTask", listTask);

        return "tasklist";
    }

    @RequestMapping(value = "todo/delete/{id}") //TODO: DELETE
    public String deleteTask(@PathVariable("id") int id){
        todoService.delete(id);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "todo/edit", method = RequestMethod.GET) //TODO: PUT
    public String editTask(Model model, @RequestParam(value = "id", required = true) int task_id){
        model.addAttribute("task", todoService.get(task_id));
        return "taskform";
    }

    @RequestMapping(value = "todo/savetask", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task){
        todoService.saveOrUpdate(task);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "todo/newtask", method = RequestMethod.GET)
    public String newTask(Model model){
        model.addAttribute("task", new Task());
        return "taskform";
    }


    

}

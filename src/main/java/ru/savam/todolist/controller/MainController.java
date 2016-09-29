package ru.savam.todolist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.savam.todolist.model.Task;
import ru.savam.todolist.service.TodoService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class MainController {

    private static final Logger logger =
            LoggerFactory.getLogger(MainController.class);

    @Autowired
    private TodoService todoService;

    @InitBinder
    public void binder(WebDataBinder binder) {binder.registerCustomEditor(Timestamp.class,
            new PropertyEditorSupport() {
                public void setAsText(String value) {
                    try {
                        Date parsedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
                        setValue(new Timestamp(parsedDate.getTime()));
                    } catch (ParseException e) {
                        setValue(null);
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listTask(Model model){
        List<Task> listTask = todoService.list();

        Timestamp time = new Timestamp(new Date().getTime());

        logger.info("Current time: " + time);
        logger.info("Current time in long: " + time.getTime());
        logger.info("Due_time: " + new Date(listTask.get(2).getDue_time().getTime()));
        logger.info("Due_time in long: " + listTask.get(2).getDue_time().getTime());

        for (Task t : listTask) { // filtering wasted task
            if(t.getDue_time().after(time)){
                t.setWasted(false);
            } else if(t.getDue_time().before(time)){
                t.setWasted(true);
            }else t.setWasted(false);
            logger.info("Current time:" + time + "Due time:" + t.getDue_time());
        }

        model.addAttribute("listTask", listTask);

        return "tasklist";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable("id") int id){
        todoService.delete(id);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editTask(Model model, @RequestParam(value = "id", required = true) int task_id){
        model.addAttribute("task", todoService.get(task_id));
        return "taskform";
    }

    @RequestMapping(value = "/savetask", method = RequestMethod.POST)
    public String saveTask(@Valid Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info("Binding Error");
            return "taskform";
        }
        if(!(task.getTask_id()>0)){
            task.setWasted(false);
            task.setDone(false);
        }
        todoService.saveOrUpdate(task);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "/newtask", method = RequestMethod.GET)
    public String newTask(Model model){
        model.addAttribute("task", new Task());
        return "taskform";
    }

}

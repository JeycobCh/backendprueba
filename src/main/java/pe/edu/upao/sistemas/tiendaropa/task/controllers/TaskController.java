package pe.edu.upao.sistemas.tiendaropa.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.sistemas.tiendaropa.task.models.Task;
import pe.edu.upao.sistemas.tiendaropa.task.services.TaskService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tasks")

public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/{id}")
    Task getTask(@PathVariable String id){
        throw new IllegalArgumentException("");
    }

    @GetMapping("/")
    List<Task> listTask(){
        return taskService.list();
    }


    @PostMapping("/")
    Task createTask(@RequestBody Task task){
        return taskService.create(task);
    }


}

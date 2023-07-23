package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.CreateTaskDTO;
import com.example.taskmanager.entities.TaskEntity;
import com.example.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        List<TaskEntity> taskList = taskService.getTasks();
        return ResponseEntity.ok(taskList);
    }

    @PostMapping("/addTask")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO createTaskDTO){
        TaskEntity task = taskService.addTask(createTaskDTO.getTitle(),createTaskDTO.getDescription());
        return ResponseEntity.ok(task);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") int taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }
}

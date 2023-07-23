package com.example.taskmanager.services;

import com.example.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskService {
    private List<TaskEntity> tasks = new ArrayList<>();
    private int taskId=1;

    public List<TaskEntity> getTasks() {
        return tasks;
    }
    public TaskEntity addTask(String title,String description){
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        task.setDeadline(new java.util.Date());
        tasks.add(task);
        taskId++;
        return task;
    }

    public TaskEntity getTaskById(int id){
        return tasks.stream().filter(t -> t.getId()==id).findFirst().orElse(null);
    }
}

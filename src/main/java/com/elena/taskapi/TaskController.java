package com.elena.taskapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;



@RestController
public class TaskController {


    private int nextId = 1;
    private List<Task> tasks = new ArrayList<>();

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/api/tasks")
    public Task createTask(@RequestBody Task task) {

        task.setId(nextId);
        nextId++;

        tasks.add(task);

        return task;
    }

    @DeleteMapping("/api/tasks/{id}")
    public String deleteTask(@PathVariable int id) {
        tasks.removeIf(task -> task.getId() == id);
        return "Task deleted";
    }

    @GetMapping("/api/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}

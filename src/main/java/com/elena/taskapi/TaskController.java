package com.elena.taskapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task(1, "Learn Spring Boot", false));
        tasks.add(new Task(2, "Build REST API", true));
        tasks.add(new Task(3, "Push to GitHub", false));

        return tasks;
    }
}

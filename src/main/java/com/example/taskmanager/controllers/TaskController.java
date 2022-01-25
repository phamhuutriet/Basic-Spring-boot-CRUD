package com.example.taskmanager.controllers;


import com.example.taskmanager.models.Task;
import com.example.taskmanager.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity fetchAll() {
        System.out.println("Fetch data successfully");
        return ResponseEntity.ok(taskService.fetchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> fetchByID(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(taskService.fetchByID(id));
    }

    @PostMapping("")
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
        return ResponseEntity.ok(taskService.createTask(newTask));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task updatedTask, @PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(taskService.updateTask(updatedTask, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") String id) {
        taskService.deleteTask(id);
        System.out.println("Deleted successfully");
        return ResponseEntity.ok().build();
    }
}


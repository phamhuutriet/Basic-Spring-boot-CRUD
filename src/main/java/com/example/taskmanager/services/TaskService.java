package com.example.taskmanager.services;

import com.example.taskmanager.models.Task;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // METHODS
    public List<Task> fetchAll() {
        return taskRepository.findAll();
    }

    public Task fetchByID(String id) throws Exception {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) throw new Exception("ID not found");
        return optionalTask.get();
    }

    public Task createTask(Task newTask) {
        return taskRepository.save(newTask);
    }

    public Task updateTask(Task updatedTask, String id) throws Exception {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) throw new Exception("ID not found");
        Task task = optionalTask.get();

        if (!task.getTitle().equals(updatedTask.getTitle())) task.setTitle(updatedTask.getTitle());
        if (task.getCompleted() != updatedTask.getCompleted()) task.setCompleted(updatedTask.getCompleted());

        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}

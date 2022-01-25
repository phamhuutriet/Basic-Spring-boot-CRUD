package com.example.taskmanager.repositories;

import com.example.taskmanager.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findAll();
}

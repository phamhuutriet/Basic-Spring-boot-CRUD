package com.example.taskmanager.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tasks")
public class Task {
  @Id
  private String id;
  private String title;
  private boolean completed;

  // CONSTRUCTOR
  public Task(String id, String title, boolean completed) {
    this.id = id;
    this.title = title;
    this.completed = completed;
  }

  // METHODS
  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean getCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}

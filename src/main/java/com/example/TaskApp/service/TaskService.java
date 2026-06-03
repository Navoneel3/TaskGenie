package com.example.TaskApp.service;

import com.example.TaskApp.domain.CreateTaskRequest;
import com.example.TaskApp.domain.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
    List<Task> listTasks();
}

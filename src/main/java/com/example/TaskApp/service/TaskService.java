package com.example.TaskApp.service;

import com.example.TaskApp.domain.CreateTaskRequest;
import com.example.TaskApp.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}

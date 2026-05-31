package com.example.TaskApp.service.impl;

import com.example.TaskApp.domain.CreateTaskRequest;
import com.example.TaskApp.domain.entity.Task;
import com.example.TaskApp.domain.entity.TaskStatus;
import com.example.TaskApp.repository.TaskRepository;
import com.example.TaskApp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now =Instant.now();
        Task task =new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
    return  taskRepository.save(task);
    }
}

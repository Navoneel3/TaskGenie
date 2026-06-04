package com.example.TaskApp.service.impl;

import com.example.TaskApp.domain.CreateTaskRequest;
import com.example.TaskApp.domain.UpdateTaskRequest;
import com.example.TaskApp.domain.entity.Task;
import com.example.TaskApp.domain.entity.TaskStatus;
import com.example.TaskApp.exception.TaskNotFoundException;
import com.example.TaskApp.repository.TaskRepository;
import com.example.TaskApp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC,"created"));
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest request) {
        Task existingTask=taskRepository.findById(id)
                .orElseThrow(()-> new TaskNotFoundException(id));

        existingTask.setTitle(request.title());
        existingTask.setDescription(request.description());
        existingTask.setDueDate(request.dueDate());
        existingTask.setPriority(request.priority());
        existingTask.setStatus(request.status());
        existingTask.setUpdated(Instant.now());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
}

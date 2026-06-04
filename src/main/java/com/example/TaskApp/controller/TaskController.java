package com.example.TaskApp.controller;

import com.example.TaskApp.domain.CreateTaskRequest;
import com.example.TaskApp.domain.UpdateTaskRequest;
import com.example.TaskApp.domain.dto.CreateTaskRequestDto;
import com.example.TaskApp.domain.dto.TaskDto;
import com.example.TaskApp.domain.dto.UpdateTaskRequestDto;
import com.example.TaskApp.domain.entity.Task;
import com.example.TaskApp.mapper.TaskMapper;
import com.example.TaskApp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService,TaskMapper taskMapper){
        this.taskService=taskService;
        this.taskMapper=taskMapper;

    }
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto){
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task=taskService.createTask(createTaskRequest);
        TaskDto taskDto=taskMapper.toDto(task);
        return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtoList = tasks.stream().map(taskMapper::toDto).toList();
        return  ResponseEntity.ok(taskDtoList);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable UUID id,@Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto) {
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
        Task task = taskService.updateTask(id, updateTaskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return ResponseEntity.ok(taskDto);
    }
}

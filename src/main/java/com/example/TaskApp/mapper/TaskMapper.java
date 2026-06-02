package com.example.TaskApp.mapper;

import com.example.TaskApp.domain.CreateTaskRequest;
import com.example.TaskApp.domain.dto.CreateTaskRequestDto;
import com.example.TaskApp.domain.dto.TaskDto;
import com.example.TaskApp.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    TaskDto toDto(Task task);

}

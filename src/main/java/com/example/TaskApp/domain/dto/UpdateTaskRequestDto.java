package com.example.TaskApp.domain.dto;

import com.example.TaskApp.domain.entity.TaskPriority;
import com.example.TaskApp.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
        @NotBlank(message =Error_Message_Title_Length )
        @Length(max=255,message =Error_Message_Title_Length )
        String title,
        @Length(max = 1000,message =Error_Message_Description_Length )
        @Nullable
        String description,
        @FutureOrPresent(message =Error_Message_Due_Date_Future )
        @Nullable
        LocalDate dueDate,
        @NotNull(message =Error_Message_TaskStatus )
        TaskStatus status,
        @NotNull(message =Error_Message_TaskPriority )
        TaskPriority priority

) {
    public static final String Error_Message_Title_Length=
            "Title Must be between 1 and 255 characters";
    public static final String Error_Message_Description_Length=
            "Description Must be less than 1000 characters";
    public static final String Error_Message_Due_Date_Future=
            "Due Date must be in Future";
    public static final String Error_Message_TaskStatus=
            "TaskStatus must be Provided";
    public static final String Error_Message_TaskPriority=
            "TaskPriority must be Provided";
}

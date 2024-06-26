package com.taskManagementSystem.TaskManager.DTOUser;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {

    private long taskId;
    private String taskTitle;
    private String taskDescription;
    private LocalDate taskDueDate;
    private String taskStatus;
    private UserDTO userDTO;
}
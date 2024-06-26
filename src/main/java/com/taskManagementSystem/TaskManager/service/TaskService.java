package com.taskManagementSystem.TaskManager.service;

import com.taskManagementSystem.TaskManager.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);
    Task getTaskById(Long taskId);
    List<Task> getAllTasks();
    Task updateTask(Task task);
    void deleteTask(Long TaskId);
}

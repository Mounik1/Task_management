package com.taskManagementSystem.TaskManager.service;

import com.taskManagementSystem.TaskManager.Repository.TaskRepository;
import com.taskManagementSystem.TaskManager.Repository.UserRepository;
import com.taskManagementSystem.TaskManager.entity.Task;
import com.taskManagementSystem.TaskManager.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImplementation implements TaskService {


    private final TaskRepository taskRepository;

    private final UserRepository userRepository;


    @Override
    public Task createTask(Task task) {
        if(task.getUser()!= null && task.getUser().getId()!=0){
            User user = userRepository.findById(task.getUser().getId()).orElseThrow();
            task.setUser(user);
        }else {
            task.setUser(null);
        }
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        return optionalTask.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        Task existingTask = taskRepository.findById(task.getId()).get();
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDeadline(task.getDeadline());
        existingTask.setStatus(task.getStatus());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);

    }
}

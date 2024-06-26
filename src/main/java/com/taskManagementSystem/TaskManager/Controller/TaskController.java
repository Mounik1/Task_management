package com.taskManagementSystem.TaskManager.Controller;


import com.taskManagementSystem.TaskManager.entity.Task;
import com.taskManagementSystem.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {


    private final TaskService taskService;


    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.createTask(task),HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Task> getByTaskId(@PathVariable("id")Long taskId){
        return new ResponseEntity<>(taskService.getTaskById(taskId), HttpStatus.OK);
    }
    @GetMapping("/getTasks")
    public ResponseEntity<List<Task>> GetAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }
    @PutMapping({"id"})
    public ResponseEntity<Task> updateTask(@PathVariable("id")Long taskId, @RequestBody Task task){
        return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id")Long taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task Deleted Successfully",HttpStatus.OK);
    }

}

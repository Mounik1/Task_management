package com.taskManagementSystem.TaskManager.Controller;

import com.taskManagementSystem.TaskManager.entity.User;
import com.taskManagementSystem.TaskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getByUserId(@PathVariable("id") Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
   @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
   }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id")Long userId, @RequestBody User user){
        return  new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }
}

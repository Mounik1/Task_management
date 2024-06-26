package com.taskManagementSystem.TaskManager.DTOUser;


import lombok.Data;

import javax.management.relation.Role;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String Password;
    private Role role;
}
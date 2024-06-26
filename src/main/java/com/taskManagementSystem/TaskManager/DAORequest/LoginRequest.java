package com.taskManagementSystem.TaskManager.DAORequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String username;
    private String password;
    private String role;
}

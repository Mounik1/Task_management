package com.taskManagementSystem.TaskManager.JWT;

import com.taskManagementSystem.TaskManager.DAORequest.LoginRequest;
import com.taskManagementSystem.TaskManager.DAORequest.RegisterRequest;
import com.taskManagementSystem.TaskManager.DAOResponse.JWTAuthenticationResponse;


public interface AuthService {

    JWTAuthenticationResponse signUp(RegisterRequest request);
    JWTAuthenticationResponse signIn(LoginRequest request);
}

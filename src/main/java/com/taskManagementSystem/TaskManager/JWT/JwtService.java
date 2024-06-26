package com.taskManagementSystem.TaskManager.JWT;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {

    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(UserDetails userDetails, String Token);

}

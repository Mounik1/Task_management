package com.taskManagementSystem.TaskManager.AuthenticationController;

import com.taskManagementSystem.TaskManager.DAORequest.LoginRequest;
import com.taskManagementSystem.TaskManager.DAORequest.RegisterRequest;
import com.taskManagementSystem.TaskManager.DAOResponse.JWTAuthenticationResponse;
import com.taskManagementSystem.TaskManager.JWT.AuthService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@Data
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<JWTAuthenticationResponse> signUp(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.signUp(request));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthenticationResponse> signIn(@RequestBody LoginRequest login){
        return ResponseEntity.ok(authService.signIn(login));
    }
}

package com.taskManagementSystem.TaskManager.JWT;

import com.taskManagementSystem.TaskManager.DAORequest.LoginRequest;
import com.taskManagementSystem.TaskManager.DAORequest.RegisterRequest;
import com.taskManagementSystem.TaskManager.DAOResponse.JWTAuthenticationResponse;
import com.taskManagementSystem.TaskManager.Repository.UserRepository;
import com.taskManagementSystem.TaskManager.entity.Role;
import com.taskManagementSystem.TaskManager.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthenticationResponse signUp(RegisterRequest request) {
        User user = User.builder().
                username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole()))
                .build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return JWTAuthenticationResponse.builder().token(jwt).build();

    }

    @Override
    public JWTAuthenticationResponse signIn(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        String jwt = jwtService.generateToken(user);
        return JWTAuthenticationResponse.builder().token(jwt).build();
    }
}
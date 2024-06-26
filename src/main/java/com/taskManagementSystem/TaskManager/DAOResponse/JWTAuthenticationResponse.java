package com.taskManagementSystem.TaskManager.DAOResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JWTAuthenticationResponse {

    private String token;

}



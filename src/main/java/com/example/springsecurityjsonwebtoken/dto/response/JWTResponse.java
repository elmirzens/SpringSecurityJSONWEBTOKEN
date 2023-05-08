package com.example.springsecurityjsonwebtoken.dto.response;

import com.example.springsecurityjsonwebtoken.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTResponse {

    private String email;
    private String token;
    private String message;
    private Role role;
}
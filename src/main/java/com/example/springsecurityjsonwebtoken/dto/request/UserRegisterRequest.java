package com.example.springsecurityjsonwebtoken.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserRegisterRequest {

    private String fullName;
    private String email;
    private String password;
}

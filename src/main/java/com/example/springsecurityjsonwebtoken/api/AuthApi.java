package com.example.springsecurityjsonwebtoken.api;

import com.example.springsecurityjsonwebtoken.dto.request.LoginRequest;
import com.example.springsecurityjsonwebtoken.dto.request.UserRegisterRequest;
import com.example.springsecurityjsonwebtoken.dto.response.JWTResponse;
import com.example.springsecurityjsonwebtoken.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping("register")
    @PermitAll
    public String registrationPerson(@RequestBody UserRegisterRequest userRegisterRequest) {
        authService.registerUser( userRegisterRequest );
        return "Siuuu";
    }

    @PostMapping("login")
    @PermitAll
    public JWTResponse performLogin(@RequestBody LoginRequest loginResponse) {
        return authService.authenticate( loginResponse );
    }

}

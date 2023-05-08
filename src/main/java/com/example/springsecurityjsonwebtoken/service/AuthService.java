package com.example.springsecurityjsonwebtoken.service;

import com.example.springsecurityjsonwebtoken.config.jwt.JwtUtils;
import com.example.springsecurityjsonwebtoken.dto.request.LoginRequest;
import com.example.springsecurityjsonwebtoken.dto.request.UserRegisterRequest;
import com.example.springsecurityjsonwebtoken.dto.response.JWTResponse;
import com.example.springsecurityjsonwebtoken.model.Role;
import com.example.springsecurityjsonwebtoken.model.User;
import com.example.springsecurityjsonwebtoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserRegisterRequest userRegisterRequest) {
        User user = new User(userRegisterRequest.getEmail());
        user.setFullName( userRegisterRequest.getFullName() );
        user.setEmail( userRegisterRequest.getEmail() );
        user.setRole( Role.USER);
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));

        if (repository.existsByEmail(userRegisterRequest.getEmail()))
            throw new RuntimeException("The email " + userRegisterRequest.getEmail() + " is already in use!");

        User savedUser = repository.save(user);
        String token = jwtUtils.generateToken(userRegisterRequest.getEmail());

        new JWTResponse(
                savedUser.getEmail(),
                token,
                "Beknur",
                savedUser.getRole()

        );
}
    public JWTResponse authenticate(LoginRequest loginRequest) {
        User user = repository.findByEmail(loginRequest.getEmail()).orElseThrow(() ->
                new RuntimeException("User with email: " + loginRequest.getEmail() + " not found!"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token = jwtUtils.generateToken(user.getEmail());
        return new JWTResponse(
                user.getEmail(),
                token,
                "Beknur",
                user.getRole()

        );
    }
}
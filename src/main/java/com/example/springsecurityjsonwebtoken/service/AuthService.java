package com.example.springsecurityjsonwebtoken.service;

import com.example.springsecurityjsonwebtoken.model.User;
import com.example.springsecurityjsonwebtoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User register(User user){
        return repository.save(user);
    }
}
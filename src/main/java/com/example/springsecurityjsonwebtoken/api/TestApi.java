package com.example.springsecurityjsonwebtoken.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("user")
    @PreAuthorize( "hasAuthority('USER')" )
    public String getUser(){
        return "Hello, I'm User";
    }

    @GetMapping("admin")
    @PreAuthorize( "hasAuthority('ADMIN')" )
    public String getAdmin(){
        return "Hello, I'm Admin";
    }
}

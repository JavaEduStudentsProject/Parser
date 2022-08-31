package com.example.parseproject.controller;

import com.example.parseproject.security.SecurityConfig;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Import(SecurityConfig.class)
public class HelloController {
    @GetMapping("/")
    public String hello(Authentication a) {
        return "Hello";
    }

    @GetMapping("/user")
    public String user(Authentication a) {
        return "User";
    }


    @GetMapping("/admin")
    public String basic(Authentication a) {
        return "Admin";
    }
}

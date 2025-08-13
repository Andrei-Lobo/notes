package com.notesbackend.notes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notesbackend.notes.model.User;
import com.notesbackend.notes.service.UserService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User newUser = uService.registerUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(newUser.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User loggedUser = uService.loginUser(user.getUsername(), user.getPassword());
        if(loggedUser != null){
            return ResponseEntity.ok(loggedUser.getId());
        }
        return ResponseEntity.status(401).body("Invalid Credentials");
    }
}

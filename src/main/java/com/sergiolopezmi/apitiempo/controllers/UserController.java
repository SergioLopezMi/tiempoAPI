package com.sergiolopezmi.apitiempo.controllers;

import com.sergiolopezmi.apitiempo.entities.User;
import com.sergiolopezmi.apitiempo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuario")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User userIn) {
        return ResponseEntity.ok()
            .body(userRepository.save(userIn));
    }
}

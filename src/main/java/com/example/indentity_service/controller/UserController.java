package com.example.indentity_service.controller;

import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.dto.request.UserUpdateRequest;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request)
    {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers()
    {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable("id") String id)
    {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable("id") String id, @RequestBody UserUpdateRequest request)
    {
        return userService.updateUser(id,request);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id") String id)
    {
        userService.deleteUser(id);
    }
}

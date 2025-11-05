package com.example.indentity_service.service;

import com.example.indentity_service.Enum.ErrorCode;
import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.dto.request.UserUpdateRequest;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.exception.ServerExCeption;
import com.example.indentity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("Đã tồn tại user");

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(String id)
    {
        return userRepository.findById(id).orElseThrow(() -> new ServerExCeption(ErrorCode.INTERNAL_SERVER_ERROR));
    }

    public User updateUser(String id, UserUpdateRequest request)
    {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));

        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public  void deleteUser(String id)
    {
        userRepository.deleteById(id);
    }
}

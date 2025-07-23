package com.example.User.service;

import com.example.User.dto.UserWithBooksResponse;
import com.example.User.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
    UserWithBooksResponse getUserWithBooks(Long userId);
}

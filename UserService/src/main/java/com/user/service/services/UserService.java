package com.user.service.services;

import com.user.service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserByUserId(String id);

    String deleteUserById(String id);

    User updateUser(User user);
}

package com.user.service.services;

import com.user.service.dto.UserDto;
import com.user.service.entities.User;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserByUserId(String id);

    String deleteUserById(String id);

    UserDto updateUser(UserDto userDto);
}

package com.user.service.services;

import com.user.service.dto.UserDto;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User newUser = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user->modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByUserId(String id) {
        User getUSer = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
        return modelMapper.map(getUSer, UserDto.class);
    }

    @Override
    public String deleteUserById(String id) {
        UserDto userDto = getUserByUserId(id);
        User user = modelMapper.map(userDto, User.class);
        userRepository.delete(user);
        return "User deleted successfully with id: " + id;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        UserDto existingUserDto = getUserByUserId(user.getUserId());

        existingUserDto.setName(user.getName());
        existingUserDto.setEmail(user.getEmail());
        existingUserDto.setAbout(user.getAbout());

        User updatedUser = modelMapper.map(existingUserDto, User.class);
        User savedUser = userRepository.save(updatedUser);
        return modelMapper.map(savedUser, UserDto.class);
    }
}
package com.user.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String userId;

    private String name;

    private String email;

    private String about;

    private List<RatingDto> ratings;
}

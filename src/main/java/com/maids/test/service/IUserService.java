package com.maids.test.service;

import com.maids.test.entities.User;
import com.maids.test.entities.dto.UserRequestDto;
import com.maids.test.entities.dto.UserResponseDto;

import java.util.List;

public interface IUserService {
    List<UserResponseDto> getUsers();

    UserResponseDto getUserById(Integer id);

    User addUser();

    UserResponseDto createUser(UserRequestDto requestDto);
}

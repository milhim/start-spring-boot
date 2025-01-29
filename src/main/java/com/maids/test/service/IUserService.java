package com.maids.test.service;

import com.maids.test.entities.User;
import com.maids.test.entities.dto.CreateUserDto;
import com.maids.test.entities.dto.UserResponseDto;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    User getUserById(Integer id);

    UserResponseDto addUser(CreateUserDto userDto);

}

package com.maids.test.service;

import com.maids.test.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    User getUserById(Integer id);

    User addUser();

}

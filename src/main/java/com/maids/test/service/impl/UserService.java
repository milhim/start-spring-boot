package com.maids.test.service.impl;

import com.maids.test.entities.User;
import com.maids.test.repositories.UserRepository;
import com.maids.test.service.IArticleService;
import com.maids.test.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final IArticleService articleService;

    public UserService(UserRepository userRepository, ArticleService articleService) {
        this.userRepository = userRepository;
        this.articleService = articleService;
    }


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User addUser() {
        return null;
    }
}

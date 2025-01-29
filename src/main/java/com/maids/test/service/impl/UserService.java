package com.maids.test.service.impl;

import com.maids.test.entities.Article;
import com.maids.test.entities.User;
import com.maids.test.entities.dto.ArticleDto;
import com.maids.test.entities.dto.CreateUserDto;
import com.maids.test.entities.dto.UserResponseDto;
import com.maids.test.repositories.ArticleRepository;
import com.maids.test.repositories.UserRepository;
import com.maids.test.service.IArticleService;
import com.maids.test.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    //    private final IArticleService articleService;
    private final ArticleRepository articleRepository;

    public UserService(UserRepository userRepository, ArticleService articleService, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
//        this.articleService = articleService;
    }


    //Todo ask about returning the UserDTO from here with the mapping
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    //Todo should we depend on articles repo or articles service
    @Override
    public UserResponseDto addUser(CreateUserDto userDto) {
        User user = new User();
        user.setEmail(userDto.EMAIL());
        User savedUser = userRepository.save(user);

        List<ArticleDto> articleDtos = userDto.ARTICLES();
        List<Article> articles = new ArrayList<>();

        articleDtos.forEach(articleDTO -> {
            Article a = new Article();
            a.setTitle(articleDTO.title());
            a.setAuthor(savedUser);
            articleRepository.save(a) ;
        });
//        user.setUserArticles(articles);

//        articleRepository.saveAllAndFlush(articles);
        User newUser = userRepository.findById(user.getId()).orElseThrow();
        return new UserResponseDto(newUser.getId(), newUser.getEmail(), newUser.getUserArticles());
    }
}

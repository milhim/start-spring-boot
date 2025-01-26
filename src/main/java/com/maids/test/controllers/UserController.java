package com.maids.test.controllers;

import com.maids.test.entities.dto.UserResponseDto;
import com.maids.test.service.IUserService;
import com.maids.test.service.impl.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/v1")
public class UserController {

    @Qualifier
    private final IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> responseDtos = new java.util.ArrayList<>(List.of());
        userService.getUsers()
                .stream()
                .map(user ->
                        responseDtos.add(new UserResponseDto(user.getId(), user.getEmail(), user.getUserArticles()))).toList();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);

    }

//
//    @PostMapping
//    public ResponseEntity<User> createUser(
//            @RequestBody UserRequesDto requestDto
//    ) {
//
//        User user = repository.save(requestDto);
//        List<Article> articles = requestDto.getUserArticles();
//
//        articles.forEach(article -> {
//            article.setAuthor(user);
//        });
//
//        articleRepository.saveAll(articles);
//
//
//        return ResponseEntity.ok(user);
//    }
}

package com.maids.test.controllers;

import com.maids.test.entities.dto.UserRequestDto;
import com.maids.test.entities.dto.UserResponseDto;
import com.maids.test.service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/v1")
public class UserController {

    @Qualifier
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> responseDtos = userService.getUsers();

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(
            @PathVariable Integer userId
    ) {
        UserResponseDto responseDtos = userService.getUserById(userId);

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @RequestBody UserRequestDto requestDto
    ) {
        UserResponseDto userResponseDto = userService.createUser(requestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    //Same above method Using Mappers
//    @GetMapping
//    public ResponseEntity<List<UserResponseDto>> getUsers() {
//        List<UserResponseDto> responseDtos = userService.getUsers()
//                .stream()
//                .map(mapper::fromUserToDto)
//                .toList();
//
//        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
//
//    }


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

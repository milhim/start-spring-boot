package com.maids.test.controllers;

import com.maids.test.entities.User;
import com.maids.test.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/v1")
public class UserController {

    private final UserRepository repository;

    public  UserController(UserRepository repository){
        this.repository=repository;
    }


    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);

    }

    @PostMapping
    public  ResponseEntity<User> createUser(
            @RequestBody User requestDto
    ){
        User user=repository.save(requestDto);
        return  ResponseEntity.ok(user);
    }
}

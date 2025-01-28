package com.maids.test.service.impl;

import com.maids.test.entities.Article;
import com.maids.test.entities.User;
import com.maids.test.entities.dto.ArticleRequestDto;
import com.maids.test.entities.dto.UserRequestDto;
import com.maids.test.entities.dto.UserResponseDto;
import com.maids.test.entities.mappers.UserMapper;
import com.maids.test.repositories.UserRepository;
import com.maids.test.service.IArticleService;
import com.maids.test.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final IArticleService articleService;
    private final UserMapper mapper;

    public UserService(UserRepository userRepository, IArticleService articleService, UserMapper mapper) {
        this.userRepository = userRepository;
        this.articleService = articleService;
        this.mapper = mapper;
    }


    @Override
    public List<UserResponseDto> getUsers() {
        return userRepository.findAll().stream()
                .map(mapper::fromUserToDto)
                .toList();

    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        return userRepository.findById(id)
                .map(mapper::fromUserToDto)
                .orElseThrow(
                        () -> new RuntimeException("User Not Found")
                );
    }

    @Override
    public User addUser() {
        return null;
    }

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto requestDto) {
        // Step 1: Map the request DTO to the User entity
        // Convert the incoming UserRequestDto to a User entity using the mapper
        User user = mapper.toUserFromDto(requestDto);

        // Step 2: Save the user first
        // Persist the user entity in the database. This ensures the user has a valid ID
        // before associating it with articles.
        userRepository.save(user);

        // Step 3: Create a list to hold the articles
        // Initialize an empty list to store the Article entities that will be created.
        List<Article> articles = new ArrayList<>();

        // Step 4: Iterate over the list of ArticleRequestDto in the request
        // For each article in the request, create an Article entity and set its properties.
        for (ArticleRequestDto article : requestDto.articles()) {
            Article articleToSave = new Article();

            // Set the title of the article from the request DTO
            articleToSave.setTitle(article.title());

            // Set the author of the article to the saved user
            // This establishes the relationship between the article and the user.
            articleToSave.setAuthor(user);
            // Step 5: Save all articles in the database
            articleService.saveArticle(articleToSave);

            // Add the article to the list of articles
            articles.add(articleToSave);
        }

        // Step 6: Set the articles list in the user entity
        // This ensures the user entity is aware of its associated articles.
        user.setArticles(articles);

        // Step 7: Map the saved User entity to a response DTO
        // Convert the saved User entity (with its associated articles) to a UserResponseDto
        // to return as the response.
        return mapper.fromUserToDto(user);
    }
}

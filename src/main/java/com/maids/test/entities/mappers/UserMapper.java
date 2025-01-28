package com.maids.test.entities.mappers;

import com.maids.test.entities.User;
import com.maids.test.entities.dto.ArticleResponseDto;
import com.maids.test.entities.dto.UserRequestDto;
import com.maids.test.entities.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {
    public User toUserFromDto(UserRequestDto requestDto) {

        if (requestDto == null) {
            return null;
        }
        User user = new User();
        user.setEmail(requestDto.email());

        return user;

    }

    public UserResponseDto fromUserToDto(User user) {
        List<ArticleResponseDto> articleResponseDtos = user.getArticles().stream()
                .map(article -> new ArticleResponseDto(
                        article.getId(),
                        article.getTitle(),
                        article.getAuthor().getId()
                )).toList();

        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                articleResponseDtos
        );
    }
}

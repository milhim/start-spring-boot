package com.maids.test.entities.dto;

import java.util.List;

public record UserRequestDto(
        String email,
        List<ArticleRequestDto> articles//we can exclude this if we do not want to create a user with articles
) {


    @Override
    public String email() {
        return email;
    }

    @Override
    public List<ArticleRequestDto> articles() {
        return articles;
    }
}

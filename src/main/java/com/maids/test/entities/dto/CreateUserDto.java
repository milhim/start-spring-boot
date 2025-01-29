package com.maids.test.entities.dto;

import java.util.List;

public record CreateUserDto(Integer ID, String EMAIL, List<ArticleDto>ARTICLES) {
    @Override
    public String EMAIL() {
        return EMAIL;
    }

    @Override
    public List<ArticleDto> ARTICLES() {
        return ARTICLES;
    }
}

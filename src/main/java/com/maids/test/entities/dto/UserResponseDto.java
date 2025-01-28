package com.maids.test.entities.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record UserResponseDto(
        Integer id,
        String email,
        List<ArticleResponseDto> articles
) {
    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public List<ArticleResponseDto> articles() {
        return articles;
    }
}

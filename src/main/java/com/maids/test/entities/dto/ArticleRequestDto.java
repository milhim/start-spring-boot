package com.maids.test.entities.dto;

public record ArticleRequestDto(
        Integer userId,
        String title
) {
    @Override
    public String title() {
        return title;
    }

    @Override
    public Integer userId() {
        return userId;
    }
}

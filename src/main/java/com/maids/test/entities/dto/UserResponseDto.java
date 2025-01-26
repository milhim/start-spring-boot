package com.maids.test.entities.dto;

import com.maids.test.entities.Article;

import java.util.List;

public record UserResponseDto(
        Integer ID,
        String EMAIL,
        List<Article> ART
) {
    @Override
    public Integer ID() {
        return ID;
    }

    @Override
    public String EMAIL() {
        return EMAIL;
    }

    @Override
    public List<Article> ART() {
        return ART;
    }
}

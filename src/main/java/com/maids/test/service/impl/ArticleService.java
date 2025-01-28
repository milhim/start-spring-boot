package com.maids.test.service.impl;

import com.maids.test.entities.Article;
import com.maids.test.repositories.ArticleRepository;
import com.maids.test.service.IArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }
}

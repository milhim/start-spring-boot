package com.maids.test.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Article> articles;

    public User(Integer id, String email, List<Article> articles) {
        this.id = id;
        this.email = email;
        this.articles = articles;
    }

    public User() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getArticles() {
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

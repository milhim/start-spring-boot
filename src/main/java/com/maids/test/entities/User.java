package com.maids.test.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @OneToMany( mappedBy = "author")
    @JsonManagedReference
    private List<Article> userArticles;

    public User(Integer id, String email, List<Article> userArticles) {
        this.id = id;
        this.email = email;
        this.userArticles = userArticles;
    }

    public User() {
    }


    public Integer getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Article> getUserArticles() {
        return this.userArticles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserArticles(List<Article> userArticles) {
        this.userArticles = userArticles;
    }
}

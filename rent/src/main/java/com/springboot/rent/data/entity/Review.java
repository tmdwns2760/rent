package com.springboot.rent.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "articles_id")
    private Articles articles;

    private String comments;

    private int rating;


    public Integer getId() {
        return this.id;
    }

    public User getWriter() {
        return this.writer;
    }

    public Articles getArticles() {
        return this.articles;
    }

    public String getComments() {
        return this.comments;
    }

    public int getRating() {
        return this.rating;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

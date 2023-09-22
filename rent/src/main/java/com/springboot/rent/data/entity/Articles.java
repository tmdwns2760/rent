package com.springboot.rent.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "articles")
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;


    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

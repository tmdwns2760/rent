package com.springboot.rent.data.repository;

import com.springboot.rent.data.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles, Integer> {
}

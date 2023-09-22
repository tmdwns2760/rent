package com.springboot.rent.data.repository;


import com.springboot.rent.data.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}

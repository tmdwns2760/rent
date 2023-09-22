package com.springboot.rent.Service;

import com.springboot.rent.data.entity.Review;
import com.springboot.rent.data.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReviewService {

    final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}
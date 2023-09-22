package com.springboot.rent.controller;

import com.springboot.rent.Service.ReviewService;
import com.springboot.rent.data.dto.ReviewRequestDto;
import com.springboot.rent.data.entity.Articles;
import com.springboot.rent.data.entity.Review;
import com.springboot.rent.data.entity.User;
import com.springboot.rent.data.repository.ArticlesRepository;
import com.springboot.rent.data.repository.ReviewRepository;
import com.springboot.rent.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final ArticlesRepository articlesRepository;

    public ReviewController(ReviewService reviewService, UserRepository userRepository,
                            ArticlesRepository articlesRepository, ReviewRepository reviewRepository) {
        this.reviewService = reviewService;
        this.userRepository = userRepository;
        this.articlesRepository = articlesRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("reviewDto", new ReviewRequestDto());
        return "reviews";
    }

    @PostMapping
    @Transactional
    public String create(@ModelAttribute("reviewDto") ReviewRequestDto reviewDto, RedirectAttributes redirectAttrs) {

        if (reviewDto.getRating() < 1 || reviewDto.getRating() > 5) {
            throw new RuntimeException("평점은 1에서 5사이입니다.");
        }

        User writer = userRepository.findById(reviewDto.getWriterId()) 
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        Articles article = articlesRepository.findById(reviewDto.getArticlesId())
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));

        Review review = new Review();
        review.setWriter(writer);
        review.setArticles(article);
        review.setComments(reviewDto.getComments());
        review.setRating(reviewDto.getRating());

        reviewRepository.save(review);

        redirectAttrs.addFlashAttribute("message", "등록되었습니다.");

        return "redirect:/reviews";
    }
}
package com.example.demo.domain.reviews.service;

import com.example.demo.domain.reviews.entity.Review;
import com.example.demo.domain.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    public Review saveReview(Review review){
        return reviewRepository.save(review);
    }
    public Optional<Review> findById(Long id){
        return reviewRepository.findById(id);
    }
    // 특정 강좌 리뷰 조회
    public List <Review> findByLectureId(Long lectureId){
        return reviewRepository.findByLectureIdOrderByCreatedDateDesc(lectureId);
    }
    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }
}

package com.example.demo.domain.reviews.controller;

import com.example.demo.domain.reviews.entity.Review;
import com.example.demo.domain.reviews.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/lectures")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/{lectureId}/reviews")
    @Operation(summary = "특정 강좌 리뷰 조회하기")
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        Review savedReview = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping("/{lectureId}/reviews")
    @Operation(summary = "특정 강좌 리뷰 조회하기")
    public ResponseEntity<List<Review>> getReviewByLectureId(@PathVariable Long lectureId){
        List<Review> reviews = reviewService.findByLectureId(lectureId);
        if(reviews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @Operation(summary = "특정 강좌 리뷰 id")
    @DeleteMapping("/{lecturedId}/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long lectureId, @PathVariable Long id){
        reviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

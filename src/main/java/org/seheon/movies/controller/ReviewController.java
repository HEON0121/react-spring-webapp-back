package org.seheon.movies.controller;

import org.seheon.movies.domain.Movie;
import org.seheon.movies.domain.Review;
import org.seheon.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>>getAllReview(){
        return new ResponseEntity<List<Review>>(reviewService.getAllReview(), HttpStatus.OK);
    }
}

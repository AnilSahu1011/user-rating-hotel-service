package com.rating.controller;

import com.rating.entities.Rating;
import com.rating.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
@AllArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        List<Rating> ratings = ratingService.getRating();
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatings(@PathVariable String id) {
        Rating rating = ratingService.getRating(id);
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = ratingService.getRatingsOfUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> ratings = ratingService.getRatingsByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }


}

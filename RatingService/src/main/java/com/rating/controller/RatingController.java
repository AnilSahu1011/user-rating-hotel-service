package com.rating.controller;

import com.rating.Dto.RatingDto;
import com.rating.entities.Rating;
import com.rating.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rating")
@AllArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingDto> saveRating(@RequestBody RatingDto ratingDto) {
        RatingDto savedRating = ratingService.createRating(ratingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping
    public ResponseEntity<List<RatingDto>> getRatings() {
        List<RatingDto> ratings = ratingService.getRating();
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> getRatings(@PathVariable String id) {
        RatingDto ratingDto = ratingService.getRating(id);
        return ResponseEntity.status(HttpStatus.OK).body(ratingDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingDto>> getRatingsByUserId(@PathVariable String userId) {
        List<RatingDto> ratings = ratingService.getRatingsOfUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RatingDto>> getRatingsByHotelId(@PathVariable String hotelId) {
        List<RatingDto> ratings = ratingService.getRatingsByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }
}

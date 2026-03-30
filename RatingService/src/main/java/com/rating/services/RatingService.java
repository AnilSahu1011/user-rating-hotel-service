package com.rating.services;

import com.rating.Dto.RatingDto;

import java.util.List;

public interface RatingService {
    RatingDto createRating(RatingDto ratingDto);
    RatingDto getRating(String id);
    List<RatingDto> getRating();
    List<RatingDto> getRatingsOfUserId(String userId);
    List<RatingDto> getRatingsByHotelId(String hotelId);
}

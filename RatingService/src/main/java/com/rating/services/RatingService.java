package com.rating.services;

import com.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    Rating getRating(String id);
    List<Rating> getRating();
    List<Rating> getRatingsOfUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);
}

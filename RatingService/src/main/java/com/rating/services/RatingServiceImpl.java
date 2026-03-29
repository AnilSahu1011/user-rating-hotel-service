package com.rating.services;

import com.rating.entities.Rating;
import com.rating.exceptions.ResourceNotFoundException;
import com.rating.repositories.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {
//  Don't @Autowired, Use @AllArgsConstructor for constructor injection it is better than field injection
    private final RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        Rating saved = ratingRepository.save(rating);
        System.out.println("Saved to DB: " + saved);
        return saved;
    }

    @Override
    public Rating getRating(String id) {
        return ratingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Rating is not present with id: "+id));
    }

    @Override
    public List<Rating> getRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsOfUserId(String userId) {
        return ratingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }
}

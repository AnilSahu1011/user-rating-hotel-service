package com.rating.services;

import com.rating.Dto.RatingDto;
import com.rating.entities.Rating;
import com.rating.exceptions.ResourceNotFoundException;
import com.rating.repositories.RatingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {


    private final RatingRepository ratingRepository;

    private final ModelMapper modelMapper;

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        String randomRatingId = UUID.randomUUID().toString();
        ratingDto.setRatingId(randomRatingId);
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        Rating savedRating = ratingRepository.save(rating);
        return modelMapper.map(savedRating, RatingDto.class);
    }

    @Override
    public RatingDto getRating(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Rating is not present with id: "+id));
        return modelMapper.map(rating, RatingDto.class);
    }

    @Override
    public List<RatingDto> getRating() {
        List<Rating> ratings = ratingRepository.findAll();
        return ratings.stream().map(rating->modelMapper.map(rating, RatingDto.class)).toList();
    }

    @Override
    public List<RatingDto> getRatingsOfUserId(String userId) {
        List<Rating> ratings = ratingRepository.findAllByUserId(userId);
        return ratings.stream().map(rating->modelMapper.map(rating, RatingDto.class)).toList();
    }

    @Override
    public List<RatingDto> getRatingsByHotelId(String hotelId) {
        List<Rating> ratings = ratingRepository.findAllByHotelId(hotelId);
        return ratings.stream().map(rating->modelMapper.map(rating, RatingDto.class)).toList();
    }
}

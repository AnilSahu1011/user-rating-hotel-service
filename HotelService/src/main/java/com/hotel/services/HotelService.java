package com.hotel.services;

import com.hotel.dto.HotelDto;
import com.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
    HotelDto createHotel(HotelDto hotelDto);
    List<HotelDto> getAllHotels();
    HotelDto getHotelById(String id);
}

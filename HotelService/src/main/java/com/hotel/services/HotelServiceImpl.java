package com.hotel.services;

import com.hotel.entities.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {

        Hotel newHotel = new Hotel();

        newHotel.setId(hotel.getId());
        newHotel.setName(hotel.getName());
        newHotel.setLocation(hotel.getLocation());
        newHotel.setLocation(hotel.getLocation());

        return hotelRepository.save(newHotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel is not present with id: "+id));
    }
}

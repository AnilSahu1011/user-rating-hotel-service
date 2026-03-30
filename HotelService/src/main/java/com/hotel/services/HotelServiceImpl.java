package com.hotel.services;

import com.hotel.dto.HotelDto;
import com.hotel.entities.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {

        String randomHotelId = UUID.randomUUID().toString();
        hotelDto.setId(randomHotelId);
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        Hotel newHotel = hotelRepository.save(hotel);
        return modelMapper.map(newHotel, HotelDto.class);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels =  hotelRepository.findAll();
        return hotels
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDto getHotelById(String id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel is not present with id: "+id));
        return modelMapper.map(hotel, HotelDto.class);
    }
}

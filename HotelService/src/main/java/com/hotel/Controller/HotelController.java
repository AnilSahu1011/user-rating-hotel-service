package com.hotel.Controller;

import com.hotel.dto.HotelDto;
import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        List<HotelDto> hotelDtos =  hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(hotelDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable String id) {
        HotelDto hotelDto =  hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotelDto);
    }
    @PostMapping()
    public ResponseEntity<HotelDto> saveHotel(@RequestBody HotelDto hotelDto) {
        HotelDto newHotelDto = hotelService.createHotel(hotelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotelDto);
    }
}

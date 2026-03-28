package com.hotel.Controller;

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
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels =  hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        Hotel hotel =  hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }
    @PostMapping()
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        Hotel newHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }
}

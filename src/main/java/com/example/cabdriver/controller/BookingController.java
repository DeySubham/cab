package com.example.cabdriver.controller;

import com.example.cabdriver.dto.BookingDto;
import com.example.cabdriver.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping("/create")
    public ResponseEntity<String> createRide(@RequestBody BookingDto dto){
        return new ResponseEntity<>(bookingService.createRide(dto.getSource(), dto.getDestination()), HttpStatus.OK);
    }

    @GetMapping("/getAllBookingForDriver/driverId")
    public ResponseEntity<List<BookingDto>> getAllBookingForDriver(@PathVariable Long driverId){
        return new ResponseEntity<>(bookingService.getAllBookingForDriver(driverId), HttpStatus.OK);
    }
}

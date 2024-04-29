package com.example.cabdriver.service;

import com.example.cabdriver.dto.BookingDto;
import com.example.cabdriver.entity.Booking;

import java.util.List;

public interface BookingService {
    public String createRide(String source, String destination);

    List<BookingDto> getAllBookingForDriver(Long driverId);
}

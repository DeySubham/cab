package com.example.cabdriver.service.impl;

import com.example.cabdriver.dto.BookingDto;
import com.example.cabdriver.entity.Booking;
import com.example.cabdriver.repository.BookingRepository;
import com.example.cabdriver.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public String createRide(String source, String destination) {
        Booking entity = bookingRepository.save(new Booking(source,destination));
        return (entity != null)?"Ride Created" :"Ride Not Created";
    }

    @Override
    public List<BookingDto> getAllBookingForDriver(Long driverId) {
        List<Booking> entity = bookingRepository.findByDriverId(driverId);
        return entity.stream().map(this::bookingToDto).toList();
    }

    private BookingDto bookingToDto(Booking entity) {
        return new BookingDto( entity.getSource(), entity.getDestination());
    }
}

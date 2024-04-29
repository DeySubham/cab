package com.example.cabdriver.repository;

import com.example.cabdriver.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDriverId(Long driverId);
}

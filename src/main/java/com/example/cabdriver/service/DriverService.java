package com.example.cabdriver.service;

import com.example.cabdriver.dto.DriverDto;
import com.example.cabdriver.entity.Driver;

import java.util.List;

public interface DriverService {
    public Driver createDriver(DriverDto payload);

    public List<DriverDto> getAllDrivers();

    public DriverDto getDriverById(String email);
}

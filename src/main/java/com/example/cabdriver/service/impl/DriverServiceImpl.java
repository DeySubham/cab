package com.example.cabdriver.service.impl;

import com.example.cabdriver.dto.DriverDto;
import com.example.cabdriver.entity.Driver;
import com.example.cabdriver.exceptionhandling.exception.EntityAlreadyExists;
import com.example.cabdriver.repository.DriverRepository;
import com.example.cabdriver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository repo;

    @Override
    public Driver createDriver(DriverDto payload) {
        List<String> emails = repo.findAllEmails();
        for(String email: emails) {
            if(Objects.equals(email, payload.getEmail())) throw new EntityAlreadyExists("This email is already used");
        }
        Driver entity = new Driver(payload.getName(), payload.getEmail(), payload.getPassword());
        return repo.save(entity);
    }

    @Override
    public List<DriverDto> getAllDrivers() {
        List<Driver> entity = repo.findAll();
        return entity.stream().map(this::driverToDto).collect(Collectors.toList());
    }

    @Override
    public DriverDto getDriverById(String email) {
        Driver entity = repo.findDriverByEmail(email);
        return driverToDto(entity);
    }

    private DriverDto driverToDto(Driver driver) {
        DriverDto dto = new DriverDto();
        dto.setName(driver.getName());
        dto.setEmail(driver.getEmail());
        dto.setPassword(driver.getPassword());
        return dto;
    }
}

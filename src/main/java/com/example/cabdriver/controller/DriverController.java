package com.example.cabdriver.controller;

import com.example.cabdriver.dto.DriverDto;
import com.example.cabdriver.entity.Driver;
import com.example.cabdriver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/driver")
public class DriverController {

    @Autowired
    DriverService service;

    @PostMapping("/create")
    public ResponseEntity<Driver> createDriver(@RequestBody DriverDto payload) {
        return new ResponseEntity<>(service.createDriver(payload), HttpStatus.CREATED);
    }

    @GetMapping("/getAllDrivers")
    public ResponseEntity<List<DriverDto>> getAllDrivers() {
        return new ResponseEntity<>(service.getAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("/getDriverById/{email}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable String email) {
        return new ResponseEntity<>(service.getDriverById(email), HttpStatus.OK);
    }

}

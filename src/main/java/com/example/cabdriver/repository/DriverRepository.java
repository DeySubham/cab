package com.example.cabdriver.repository;

import com.example.cabdriver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    public Driver findDriverByEmail(String email);

    @Query("SELECT d.email FROM Driver d")
    List<String> findAllEmails();
}

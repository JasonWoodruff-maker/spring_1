package com.example.demo.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Carrepository extends JpaRepository<Car, Long>{

    @Query("SELECT s from Car s WHERE s.vin = ?1")
    Optional<Car> findByvin(Long vin);
}

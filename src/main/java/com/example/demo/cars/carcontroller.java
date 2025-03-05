package com.example.demo.cars;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class carcontroller {
    private final carservice carservice;

    @Autowired
    public carcontroller(carservice carservice) { this.carservice = carservice; }
    @GetMapping
    public List<Car> hello() {
        return carservice.getcar();

    }


}
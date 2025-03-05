package com.example.demo.cars;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class carservice {

    public List<Car> getcar() {
        return List.of(
                new Car(
                        123L,
                        "Ford",
                        "F150",
                        "red"
                )
        );
    }
}

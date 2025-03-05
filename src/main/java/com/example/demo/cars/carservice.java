package com.example.demo.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Optional;

@Service
public class carservice {
    private final Carrepository carrepository;


    @Autowired
    public carservice(Carrepository carrepository) {
        this.carrepository = carrepository;
    }

    public List<Car> getcar() {
        return carrepository.findAll();
    }


    public void NewCar(Car car){
        Optional<Car> vehicle = carrepository.findByvin(car.getVin());
        System.out.println(car);
        if(vehicle.isPresent()){
            throw new IllegalStateException("Wrong vin");
        }
        carrepository.save(car);
    }
}

package com.example.demo.cars;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.beans.Transient;
import java.util.List;
import java.util.Objects;
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
    public void deletecar(Long vin){
        boolean exists = carrepository.existsById(vin);
        if(!exists){
            throw new IllegalStateException("That car does not exists");
        }
        carrepository.deleteById(vin);

    }
    @Transactional
    public void updatecar(Long vin, String color, String model){
        Car car = carrepository.findByvin(vin).orElseThrow(() -> new IllegalStateException("car with the vin doesnt exist"));

        if (model != null && model.length() > 0 && !Objects.equals(car.getModel(), model)){
            car.setModel(model);
        }
        if(color != null && color.length() > 0 && !Objects.equals(car.getColor(), color)){
            car.setColor(color);

        }
    }
}

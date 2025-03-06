package com.example.demo.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class carcontroller {
    private final carservice carservice;

    @Autowired
    public carcontroller(carservice carservice) { this.carservice = carservice; }

    @GetMapping
    public List<Car> getcar() {
        return carservice.getcar();

    }
    @PostMapping
    public void newcar(@RequestBody Car car){
        carservice.NewCar(car);
    }
    @DeleteMapping(path = "{vin}")
    public void deletecar(@PathVariable("vin") Long vin){
        carservice.deletecar(vin);
    }
    @PutMapping(path = "{vin}")
    public void updatecar(
            @PathVariable("vin") Long vin,
            @RequestParam(required = false) String color,
            @RequestParam(required = false)String model){
        carservice.updatecar(vin, color, model);
    }
}
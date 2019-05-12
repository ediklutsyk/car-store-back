package com.store.car.controller;

import com.store.car.db.persistence.Car;
import com.store.car.exceptions.NotFoundException;
import com.store.car.json.request.FilterRequest;
import com.store.car.service.car.CarService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping(value = "/car/{id}")
    public Car getAllCars(@PathVariable("id") Integer id) {
        return carService.findById(id).orElseThrow(() -> new NotFoundException("Car with such an id not found"));
    }

    @PostMapping("/cars/filter")
    public List<Car> filterEquips(@RequestBody @Valid FilterRequest request) {
        return carService.filter(request);
    }
}

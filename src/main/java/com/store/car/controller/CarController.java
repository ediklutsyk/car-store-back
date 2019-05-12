package com.store.car.controller;

import com.store.car.db.persistence.Car;
import com.store.car.exceptions.NotFoundException;
import com.store.car.json.request.CarRequest;
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

    @PostMapping(value = "/admin/car")
    public Car createCar(@RequestBody @Valid CarRequest request) {
        return carService.save(request);
    }

    @PostMapping(value = "/admin/car/update")
    public Car updateCar(@RequestBody @Valid CarRequest request) {
        Car car = carService.findById(request.getId()).orElseThrow(() -> new NotFoundException("Car with such an id not found"));
        car.setModel(request.getModel());
        car.setBrand(request.getBrand());
        car.setYear(request.getYear());
        car.setColor(request.getColor());
        car.setDriveType(request.getDriveType());
        car.setTransportType(request.getTransportType());
        car.setMileage(request.getMileage());
        car.setDoorsAmount(request.getDoorsAmount());
        car.setEngineType(request.getEngineType());
        car.setPassengerAmount(request.getPassengerAmount());
        car.setAmount(request.getAmount());
        return carService.update(car);
    }

    @PostMapping("/cars/filter")
    public List<Car> filterEquips(@RequestBody @Valid FilterRequest request) {
        return carService.filter(request);
    }
}

package com.store.car.controller;

import com.store.car.common.Product;
import com.store.car.db.persistence.Car;
import com.store.car.db.persistence.User;
import com.store.car.exceptions.NotFoundException;
import com.store.car.json.request.BuyRequest;
import com.store.car.json.request.CarRequest;
import com.store.car.json.request.FilterRequest;
import com.store.car.json.response.MessageResponse;
import com.store.car.service.car.CarService;
import com.store.car.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController extends BaseController {
    private final CarService carService;
    private final UserService userService;

    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping(value = "/cars")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping(value = "/car/{id}")
    public Car getAllCars(@PathVariable("id") Integer id) {
        return carService.findById(id).orElseThrow(() -> new NotFoundException("Car with such an id not found"));
    }

    @PostMapping(value = "/buy/car")
    public MessageResponse buyCar(@RequestBody @Valid BuyRequest request) {
        Product product = carService.findById(request.getProductId()).orElseThrow(() -> new NotFoundException("Car with such an id not found"));
        User user = userService.findById(request.getUserId()).orElseThrow(() -> new NotFoundException("No such user"));
        userService.buyProduct(user, product);
        return new MessageResponse("Successfully bought");
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

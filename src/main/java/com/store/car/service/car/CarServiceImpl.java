package com.store.car.service.car;

import com.store.car.db.persistence.Car;
import com.store.car.exceptions.BadRequestException;
import com.store.car.exceptions.NotFoundException;
import com.store.car.repositories.CarRepository;

import java.util.List;
import java.util.Optional;

public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void buy(Integer id) {
        Car car = findById(id).orElseThrow(() -> new NotFoundException("Car with such an id not found"));
        if (car.getAmount() < 1) {
            throw new BadRequestException("This car is not available for buying now");
        }
        car.setAmount(car.getAmount() - 1);
        save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> filter() {
        return null;
    }
}

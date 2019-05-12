package com.store.car.service.car;

import com.store.car.db.persistence.Car;
import com.store.car.json.request.FilterRequest;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car save(Car car);

    void delete(Car car);

    void buy(Integer id);

    List<Car> findAll();

    Optional<Car> findById(Integer id);

    List<Car> filter(FilterRequest request);
}

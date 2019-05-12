package com.store.car.service.car;

import com.store.car.db.persistence.Car;
import com.store.car.exceptions.BadRequestException;
import com.store.car.exceptions.NotFoundException;
import com.store.car.json.request.FilterRequest;
import com.store.car.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
    public List<Car> filter(FilterRequest request) {
        List<Car> result = new ArrayList<>();
        if (request.getModel() != null && !request.getModel().isEmpty()) {
            result.addAll(carRepository.findByModelLike(request.getModel()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            result.addAll(carRepository.findByBrandIn(request.getBrands()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            result.addAll(carRepository.findByYearIn(request.getYears()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            result.addAll(carRepository.findByColorIn(request.getColors()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            result.addAll(carRepository.findByDriveTypeIn(request.getDriveTypes()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            result.addAll(carRepository.findByTransportTypeIn(request.getTransportTypes()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            result.addAll(carRepository.findByEngineTypeIn(request.getEngineTypes()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            result.addAll(carRepository.findByPassengerAmountIn(request.getPassengerAmount()));
        }
        return result.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

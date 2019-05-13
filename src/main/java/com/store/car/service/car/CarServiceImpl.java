package com.store.car.service.car;

import com.store.car.db.persistence.Car;
import com.store.car.json.request.CarRequest;
import com.store.car.json.request.FilterRequest;
import com.store.car.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(CarRequest request) {
        Car car = new Car();
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
        car.setImgId(request.getImgId());
        car.setAmount(1);
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
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
            filterByParams(result, carRepository.findByModelContainingIgnoreCase(request.getModel()));
        }
        if (request.getBrands() != null && !request.getBrands().isEmpty()) {
            filterByParams(result, carRepository.findByBrandIn(request.getBrands()));
        }
        if (request.getBrands() != null && !request.getYears().isEmpty()) {
            filterByParams(result, carRepository.findByYearIn(request.getYears()));
        }
        if (request.getBrands() != null && !request.getColors().isEmpty()) {
            filterByParams(result, carRepository.findByColorIn(request.getColors()));
        }
        if (request.getBrands() != null && !request.getDriveTypes().isEmpty()) {
            filterByParams(result, carRepository.findByDriveTypeIn(request.getDriveTypes()));
        }
        if (request.getBrands() != null && !request.getTransportTypes().isEmpty()) {
            filterByParams(result, carRepository.findByTransportTypeIn(request.getTransportTypes()));
        }
        if (request.getBrands() != null && !request.getEngineTypes().isEmpty()) {
            filterByParams(result, carRepository.findByEngineTypeIn(request.getEngineTypes()));
        }
        if (request.getBrands() != null && !request.getPassengerAmount().isEmpty()) {
            filterByParams(result, carRepository.findByPassengerAmountIn(request.getPassengerAmount()));
        }
//        return result.stream()
//                .distinct()
//                .collect(Collectors.toList());
        return result;
    }

    private void filterByParams(List<Car> filterResult, List<Car> filterParams) {
        if (filterResult.isEmpty()) {
            filterResult.addAll(filterParams);
        } else {
            filterResult.retainAll(filterParams);
        }
    }
}

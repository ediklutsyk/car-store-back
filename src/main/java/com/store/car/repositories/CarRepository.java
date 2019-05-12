package com.store.car.repositories;

import com.store.car.db.persistence.Car;
import com.store.car.utils.enums.DriveType;
import com.store.car.utils.enums.EngineType;
import com.store.car.utils.enums.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Optional<Car> findById(Integer id);

    Optional<Car> findByModel(String model);

    List<Car> findByBrandIn(List<String> brands);

    List<Car> findByYearIn(List<String> years);

    List<Car> findByColorIn(List<String> colors);

    List<Car> findByDriveTypeIn(List<DriveType> driveTypes);

    List<Car> findByTransportTypeIn(List<TransportType> transportTypes);

    List<Car> findByEngineTypeIn(List<EngineType> engineTypes);

    List<Car> findByPassengerAmountIn(List<Short> amounts);
}
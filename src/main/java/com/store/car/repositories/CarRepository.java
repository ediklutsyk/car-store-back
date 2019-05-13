package com.store.car.repositories;

import com.store.car.db.persistence.Car;
import com.store.car.utils.enums.DriveType;
import com.store.car.utils.enums.EngineType;
import com.store.car.utils.enums.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Optional<Car> findById(Integer id);

    List<Car> findByModelContainingIgnoreCase(String model);

    List<Car> findByBrandIn(List<String> brands);

    List<Car> findByYearIn(List<Integer> years);

    List<Car> findByColorIn(List<String> colors);

    List<Car> findByDriveTypeIn(List<DriveType> driveTypes);

    List<Car> findByTransportTypeIn(List<TransportType> transportTypes);

    List<Car> findByEngineTypeIn(List<EngineType> engineTypes);

    List<Car> findByPassengerAmountIn(List<Short> amounts);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Car c set c.amount = :amount where c.id = :id")
    void updateCarSetAmountForId(@Param("amount") Integer amount, @Param("id") Integer id);
}
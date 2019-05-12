package com.store.car.repositories;

import com.store.car.db.persistence.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImgRepository extends JpaRepository<Img, Integer> {
    Optional<Img> findById(Integer id);
}

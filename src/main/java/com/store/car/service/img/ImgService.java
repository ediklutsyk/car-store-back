package com.store.car.service.img;

import com.store.car.db.persistence.Img;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ImgService {
    Img save(MultipartFile file);

    void delete(Img img);

    Optional<Img> findById(Integer id);
}
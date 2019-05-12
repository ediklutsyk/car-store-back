package com.store.car.service.img;

import com.store.car.db.persistence.Img;
import com.store.car.exceptions.BadRequestException;
import com.store.car.repositories.ImgRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImgServiceImpl implements ImgService {
    private final ImgRepository imgRepository;

    public ImgServiceImpl(ImgRepository imgRepository) {
        this.imgRepository = imgRepository;
    }

    @Override
    public Img save(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            Img img = new Img(fileName, file.getContentType(), file.getBytes());
            return imgRepository.save(img);
        } catch (IOException ex) {
            throw new BadRequestException("Could not store file " + fileName + ". Please try again!");
        }
    }

    @Override
    public void delete(Img img) {
        imgRepository.delete(img);
    }

    @Override
    public Optional<Img> findById(Integer id) {
        return imgRepository.findById(id);
    }
}

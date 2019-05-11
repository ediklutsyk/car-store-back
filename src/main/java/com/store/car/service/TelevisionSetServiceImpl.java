package com.store.car.service;

import com.store.car.common.entity.Product;
import com.store.car.converter.TelevisionSetConverter;
import com.store.car.dao.TelevisionSetDao;
import com.store.car.dto.TelevisionSetDto;
import com.store.car.entity.TelevisionSetImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelevisionSetServiceImpl implements TelevisionSetService {

    private final TelevisionSetDao televisionSetDao;
    private final TelevisionSetConverter televisionSetConverter;

    @Autowired
    public TelevisionSetServiceImpl(TelevisionSetDao televisionSetDao,
                                    TelevisionSetConverter televisionSetConverter) {
        this.televisionSetDao = televisionSetDao;
        this.televisionSetConverter = televisionSetConverter;
    }

    @Override
    public List<TelevisionSetDto> getAll() {
        return televisionSetDao.getAll().stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getImagesByTvId(int tvId) {
        return televisionSetDao.getImagesByTvId(tvId).stream()
                .map(TelevisionSetImage::getImage)
                .collect(Collectors.toList());
    }

    @Override
    public void buy(int id) {
        Product product = televisionSetDao.getById(id);
        televisionSetDao.buy(product);
    }

    @Override
    public void createTV(TelevisionSetDto televisionSetDto) {
        televisionSetDao.createTV(televisionSetConverter.toEntity(televisionSetDto));
    }

    @Override
    public void updateTV(TelevisionSetDto televisionSetDto) {
        televisionSetDao.updateTV(televisionSetConverter.toEntity(televisionSetDto));
    }

    @Override
    public void deleteTV(int id) {
        televisionSetDao.deleteTV(id);
    }

}

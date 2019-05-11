package com.store.car.service;

import com.store.car.dto.TelevisionSetDto;

import java.util.List;

public interface TelevisionSetService {

    List<TelevisionSetDto> getAll();

    List<String> getImagesByTvId(int tvId);

    void buy(int id);

    void createTV(TelevisionSetDto televisionSetDto);

    void updateTV(TelevisionSetDto televisionSetDto);

    void deleteTV(int id);
}

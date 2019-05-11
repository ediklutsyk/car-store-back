package com.store.car.service;

import com.store.car.dto.TelevisionSetDto;
import com.store.car.dto.TelevisionSetFilterDto;

import java.util.List;

public interface TelevisionSetSearchService {

    List<TelevisionSetDto> searchByName(String name);

    List<TelevisionSetDto> searchByDiagonal(List<String> diagonals);

    List<TelevisionSetDto> searchByDigitalTunerBand(List<String> digitalTunerBands);

    List<TelevisionSetDto> searchByManufacturer(List<String> manufacturers);

    List<TelevisionSetDto> searchByResolution(List<String> resolutions);

    List<TelevisionSetDto> searchBySpecialProps(List<String> specialProps);

    List<TelevisionSetDto> searchByWifiModule(Boolean isWifi);

    List<TelevisionSetDto> filters(TelevisionSetFilterDto televisionSetFilterDto);
}

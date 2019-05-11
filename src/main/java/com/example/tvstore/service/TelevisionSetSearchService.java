package com.example.tvstore.service;

import com.example.tvstore.dto.TelevisionSetDto;
import com.example.tvstore.dto.TelevisionSetFilterDto;

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

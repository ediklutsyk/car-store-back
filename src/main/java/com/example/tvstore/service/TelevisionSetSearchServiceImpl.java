package com.example.tvstore.service;

import com.example.tvstore.converter.TelevisionSetConverter;
import com.example.tvstore.dao.TelevisionSetSearchDao;
import com.example.tvstore.dto.TelevisionSetDto;
import com.example.tvstore.dto.TelevisionSetFilterDto;
import com.example.tvstore.entity.TelevisionSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelevisionSetSearchServiceImpl implements TelevisionSetSearchService {

    private final TelevisionSetSearchDao televisionSetSearchDao;
    private final TelevisionSetConverter televisionSetConverter;

    @Autowired
    public TelevisionSetSearchServiceImpl(TelevisionSetSearchDao televisionSetSearchDao,
                                          TelevisionSetConverter televisionSetConverter) {
        this.televisionSetSearchDao = televisionSetSearchDao;
        this.televisionSetConverter = televisionSetConverter;
    }

    @Override
    public List<TelevisionSetDto> searchByName(String name) {
        return televisionSetSearchDao.searchByName(name).stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelevisionSetDto> searchByDiagonal(List<String> diagonals) {
        return televisionSetSearchDao.searchByDiagonal(diagonals).stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelevisionSetDto> searchByDigitalTunerBand(List<String> digitalTunerBands) {
        return televisionSetSearchDao.searchByDigitalTunerBand(digitalTunerBands).stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelevisionSetDto> searchByManufacturer(List<String> manufacturers) {
        return televisionSetSearchDao.searchByManufacturer(manufacturers).stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelevisionSetDto> searchByResolution(List<String> resolutions) {
        return televisionSetSearchDao.searchByResolution(resolutions).stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelevisionSetDto> searchBySpecialProps(List<String> specialProps) {
        return televisionSetSearchDao.searchBySpecialProps(specialProps).stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelevisionSetDto> searchByWifiModule(Boolean isWifi) {
        return televisionSetSearchDao.searchByWifiModule(isWifi).stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelevisionSetDto> filters(TelevisionSetFilterDto televisionSetFilterDto) {
        List<TelevisionSet> filterResult = new ArrayList<>();

        if (televisionSetFilterDto.getDiagonal() != null && !televisionSetFilterDto.getDiagonal().isEmpty()) {
            List<TelevisionSet> resultByDiagonal = televisionSetSearchDao.searchByDiagonal(televisionSetFilterDto.getDiagonal());
            filterByParams(filterResult, resultByDiagonal);
        }
        if (televisionSetFilterDto.getDigitalTunerBand() != null && !televisionSetFilterDto.getDigitalTunerBand().isEmpty()) {
            List<TelevisionSet> resultByDigitalTunerBand =televisionSetSearchDao.searchByDigitalTunerBand(televisionSetFilterDto.getDigitalTunerBand());
            filterByParams(filterResult, resultByDigitalTunerBand);
        }
        if (televisionSetFilterDto.getManufacturer() != null && !televisionSetFilterDto.getManufacturer().isEmpty()) {
            List<TelevisionSet> resultByManufacturer = televisionSetSearchDao.searchByManufacturer(televisionSetFilterDto.getManufacturer());
            filterByParams(filterResult, resultByManufacturer);
        }
        if (televisionSetFilterDto.getResolution() != null && !televisionSetFilterDto.getResolution().isEmpty()) {
            List<TelevisionSet> resultByResolution = televisionSetSearchDao.searchByResolution(televisionSetFilterDto.getResolution());
            filterByParams(filterResult, resultByResolution);
        }
        if (televisionSetFilterDto.getSpecialProperty() != null && !televisionSetFilterDto.getSpecialProperty().isEmpty()) {
            List<TelevisionSet> resultBySpecialProps = televisionSetSearchDao.searchBySpecialProps(televisionSetFilterDto.getSpecialProperty());
            filterByParams(filterResult, resultBySpecialProps);
        }
        if (televisionSetFilterDto.getWifi() != null) {
            List<TelevisionSet> resultByWifi = televisionSetSearchDao.searchByWifiModule(televisionSetFilterDto.getWifi());
            filterByParams(filterResult, resultByWifi);
        }

        return filterResult.stream()
                .map(televisionSetConverter::toDto)
                .collect(Collectors.toList());
    }

    private void filterByParams(List<TelevisionSet> filterResult, List<TelevisionSet> filterParams) {
        if (filterResult.isEmpty()) {
            filterResult.addAll(filterParams);
        } else {
            filterResult.retainAll(filterParams);
        }
    }
}

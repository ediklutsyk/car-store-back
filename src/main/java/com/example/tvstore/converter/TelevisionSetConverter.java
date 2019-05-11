package com.example.tvstore.converter;

import com.example.tvstore.common.util.EntityDtoConverter;
import com.example.tvstore.dto.TelevisionSetDto;
import com.example.tvstore.entity.TelevisionSet;
import org.springframework.stereotype.Component;

@Component
public class TelevisionSetConverter implements EntityDtoConverter<TelevisionSet, TelevisionSetDto> {

    @Override
    public TelevisionSetDto toDto(TelevisionSet televisionSet) {
        TelevisionSetDto televisionSetDto = new TelevisionSetDto();

        televisionSetDto.setId(televisionSet.getId());
        televisionSetDto.setName(televisionSet.getName());
        televisionSetDto.setDiagonal(televisionSet.getDiagonal());
        televisionSetDto.setResolution(televisionSet.getResolution());
        televisionSetDto.setDigitalTunerBand(televisionSet.getDigitalTunerBand());
        televisionSetDto.setWiFiModule(televisionSet.isWiFiModule());
        televisionSetDto.setManufacturer(televisionSet.getManufacturer());
        televisionSetDto.setSpecialProperty(televisionSet.getSpecialProperty());
        televisionSetDto.setDescription(televisionSet.getDescription());
        televisionSetDto.setPrice(televisionSet.getPrice());
        televisionSetDto.setPlatform(televisionSet.getPlatform());
        televisionSetDto.setUpdate(televisionSet.getUpdate());
        televisionSetDto.setSweep(televisionSet.getSweep());
        televisionSetDto.setColor(televisionSet.getColor());
        televisionSetDto.setSizeWithStand(televisionSet.getSizeWithStand());
        televisionSetDto.setWeightWithStand(televisionSet.getWeightWithStand());
        televisionSetDto.setMainImage(televisionSet.getMainImage());
        televisionSetDto.setAmount(televisionSet.getAmount());

        return televisionSetDto;
    }

    @Override
    public TelevisionSet toEntity(TelevisionSetDto televisionSetDto) {
        TelevisionSet televisionSet = new TelevisionSet();

        televisionSet.setId(televisionSetDto.getId());
        televisionSet.setName(televisionSetDto.getName());
        televisionSet.setDiagonal(televisionSetDto.getDiagonal());
        televisionSet.setResolution(televisionSetDto.getResolution());
        televisionSet.setDigitalTunerBand(televisionSetDto.getDigitalTunerBand());
        televisionSet.setWiFiModule(televisionSetDto.isWiFiModule());
        televisionSet.setManufacturer(televisionSetDto.getManufacturer());
        televisionSet.setSpecialProperty(televisionSetDto.getSpecialProperty());
        televisionSet.setDescription(televisionSetDto.getDescription());
        televisionSet.setPrice(televisionSetDto.getPrice());
        televisionSet.setPlatform(televisionSetDto.getPlatform());
        televisionSet.setUpdate(televisionSetDto.getUpdate());
        televisionSet.setSweep(televisionSetDto.getSweep());
        televisionSet.setColor(televisionSetDto.getColor());
        televisionSet.setSizeWithStand(televisionSetDto.getSizeWithStand());
        televisionSet.setWeightWithStand(televisionSetDto.getWeightWithStand());
        televisionSet.setMainImage(televisionSetDto.getMainImage());
        televisionSet.setAmount(televisionSetDto.getAmount());

        return televisionSet;
    }
}

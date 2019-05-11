package com.store.car.dto;

import java.util.List;

public class TelevisionSetFilterDto {

    private List<String> diagonal;

    private List<String> digitalTunerBand;

    private List<String> manufacturer;

    private List<String> resolution;

    private List<String> specialProperty;

    private Boolean wifi;

    public List<String> getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(List<String> diagonal) {
        this.diagonal = diagonal;
    }

    public List<String> getDigitalTunerBand() {
        return digitalTunerBand;
    }

    public void setDigitalTunerBand(List<String> digitalTunerBand) {
        this.digitalTunerBand = digitalTunerBand;
    }

    public List<String> getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(List<String> manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<String> getResolution() {
        return resolution;
    }

    public void setResolution(List<String> resolution) {
        this.resolution = resolution;
    }

    public List<String> getSpecialProperty() {
        return specialProperty;
    }

    public void setSpecialProperty(List<String> specialProperty) {
        this.specialProperty = specialProperty;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }
}

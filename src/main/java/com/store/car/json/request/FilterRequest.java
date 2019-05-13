package com.store.car.json.request;

import com.store.car.utils.enums.DriveType;
import com.store.car.utils.enums.EngineType;
import com.store.car.utils.enums.TransportType;

import java.util.List;

public class FilterRequest {

    private List<String> brands;
    private String model;
    private List<Integer> years;
    private List<String> colors;
    private List<DriveType> driveTypes;
    private List<TransportType> transportTypes;
    private List<EngineType> engineTypes;
    private List<Short> passengerAmount;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<DriveType> getDriveTypes() {
        return driveTypes;
    }

    public void setDriveTypes(List<DriveType> driveTypes) {
        this.driveTypes = driveTypes;
    }

    public List<TransportType> getTransportTypes() {
        return transportTypes;
    }

    public void setTransportTypes(List<TransportType> transportTypes) {
        this.transportTypes = transportTypes;
    }

    public List<EngineType> getEngineTypes() {
        return engineTypes;
    }

    public void setEngineTypes(List<EngineType> engineTypes) {
        this.engineTypes = engineTypes;
    }

    public List<Short> getPassengerAmount() {
        return passengerAmount;
    }

    public void setPassengerAmount(List<Short> passengerAmount) {
        this.passengerAmount = passengerAmount;
    }
}

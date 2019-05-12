package com.store.car.json.request;

import com.store.car.utils.enums.DriveType;
import com.store.car.utils.enums.EngineType;
import com.store.car.utils.enums.TransportType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CarRequest {
    private Integer id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    @Min(value = 1900)
    @Max(value = 2019)
    private Integer year;
    @NotNull
    private String color;
    @NotNull
    private DriveType driveType;
    @NotNull
    private TransportType transportType;
    @NotNull
    @Min(value = 0)
    private Long mileage;
    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private Short doorsAmount;
    @NotNull
    private EngineType engineType;
    @Max(value = 100)
    private Short passengerAmount;
    @NotNull
    private Integer imgId;
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Short getDoorsAmount() {
        return doorsAmount;
    }

    public void setDoorsAmount(Short doorsAmount) {
        this.doorsAmount = doorsAmount;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Short getPassengerAmount() {
        return passengerAmount;
    }

    public void setPassengerAmount(Short passengerAmount) {
        this.passengerAmount = passengerAmount;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}


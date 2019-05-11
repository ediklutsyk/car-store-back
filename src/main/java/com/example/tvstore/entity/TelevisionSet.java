package com.example.tvstore.entity;

import com.example.tvstore.common.entity.Product;

import java.util.Objects;

public class TelevisionSet extends Product {

    private String diagonal;
    private String resolution;
    private String digitalTunerBand;
    private boolean wiFiModule;
    private String manufacturer;
    private String specialProperty;
    private String description;
    private double price;
    private String platform;
    private String update;
    private String sweep;
    private String color;
    private String sizeWithStand;
    private String weightWithStand;
    private String mainImage;
    private int amount;

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDigitalTunerBand() {
        return digitalTunerBand;
    }

    public void setDigitalTunerBand(String digitalTunerBand) {
        this.digitalTunerBand = digitalTunerBand;
    }

    public boolean isWiFiModule() {
        return wiFiModule;
    }

    public void setWiFiModule(boolean wiFiModule) {
        this.wiFiModule = wiFiModule;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSpecialProperty() {
        return specialProperty;
    }

    public void setSpecialProperty(String specialProperty) {
        this.specialProperty = specialProperty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getSweep() {
        return sweep;
    }

    public void setSweep(String sweep) {
        this.sweep = sweep;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSizeWithStand() {
        return sizeWithStand;
    }

    public void setSizeWithStand(String sizeWithStand) {
        this.sizeWithStand = sizeWithStand;
    }

    public String getWeightWithStand() {
        return weightWithStand;
    }

    public void setWeightWithStand(String weightWithStand) {
        this.weightWithStand = weightWithStand;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelevisionSet that = (TelevisionSet) o;
        return wiFiModule == that.wiFiModule &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(diagonal, that.diagonal) &&
                Objects.equals(resolution, that.resolution) &&
                Objects.equals(digitalTunerBand, that.digitalTunerBand) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(specialProperty, that.specialProperty) &&
                Objects.equals(description, that.description) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(update, that.update) &&
                Objects.equals(sweep, that.sweep) &&
                Objects.equals(color, that.color) &&
                Objects.equals(sizeWithStand, that.sizeWithStand) &&
                Objects.equals(weightWithStand, that.weightWithStand) &&
                Objects.equals(mainImage, that.mainImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagonal, resolution, digitalTunerBand, wiFiModule, manufacturer, specialProperty, description, price, platform, update, sweep, color, sizeWithStand, weightWithStand, mainImage);
    }
}

package com.store.car.db.persistence;

import com.store.car.common.Product;
import com.store.car.utils.enums.DriveType;
import com.store.car.utils.enums.EngineType;
import com.store.car.utils.enums.TransportType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "car")
public class Car extends Product implements Serializable {
    private Integer id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    @Enumerated(EnumType.STRING)
    private DriveType driveType;
    @Enumerated(EnumType.STRING)
    private TransportType transportType;
    private Long mileage;
    private Short doorsAmount;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    private Short passengerAmount;
    private Integer imgId;
    private Integer amount;
    private BigDecimal price;

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Override
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

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getId() != null ? !getId().equals(car.getId()) : car.getId() != null) return false;
        if (getBrand() != null ? !getBrand().equals(car.getBrand()) : car.getBrand() != null) return false;
        if (getModel() != null ? !getModel().equals(car.getModel()) : car.getModel() != null) return false;
        if (getYear() != null ? !getYear().equals(car.getYear()) : car.getYear() != null) return false;
        if (getColor() != null ? !getColor().equals(car.getColor()) : car.getColor() != null) return false;
        if (getDriveType() != car.getDriveType()) return false;
        if (getTransportType() != car.getTransportType()) return false;
        if (getMileage() != null ? !getMileage().equals(car.getMileage()) : car.getMileage() != null) return false;
        if (getDoorsAmount() != null ? !getDoorsAmount().equals(car.getDoorsAmount()) : car.getDoorsAmount() != null)
            return false;
        if (getEngineType() != car.getEngineType()) return false;
        if (getPassengerAmount() != null ? !getPassengerAmount().equals(car.getPassengerAmount()) : car.getPassengerAmount() != null)
            return false;
        if (getImgId() != null ? !getImgId().equals(car.getImgId()) : car.getImgId() != null) return false;
        if (getAmount() != null ? !getAmount().equals(car.getAmount()) : car.getAmount() != null) return false;
        return getPrice() != null ? getPrice().equals(car.getPrice()) : car.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getDriveType() != null ? getDriveType().hashCode() : 0);
        result = 31 * result + (getTransportType() != null ? getTransportType().hashCode() : 0);
        result = 31 * result + (getMileage() != null ? getMileage().hashCode() : 0);
        result = 31 * result + (getDoorsAmount() != null ? getDoorsAmount().hashCode() : 0);
        result = 31 * result + (getEngineType() != null ? getEngineType().hashCode() : 0);
        result = 31 * result + (getPassengerAmount() != null ? getPassengerAmount().hashCode() : 0);
        result = 31 * result + (getImgId() != null ? getImgId().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", driveType=" + driveType +
                ", transportType=" + transportType +
                ", mileage=" + mileage +
                ", doorsAmount=" + doorsAmount +
                ", engineType=" + engineType +
                ", passengerAmount=" + passengerAmount +
                ", imgId=" + imgId +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}

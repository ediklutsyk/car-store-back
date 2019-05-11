package com.store.car.mapper;

import com.store.car.entity.TelevisionSet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TelevisionSetMapper implements RowMapper<TelevisionSet> {
    @Override
    public TelevisionSet mapRow(ResultSet rs, int rowNum) throws SQLException {
        TelevisionSet televisionSet = new TelevisionSet();

        televisionSet.setId(rs.getInt(1));
        televisionSet.setName(rs.getString(2));
        televisionSet.setDiagonal(rs.getString(3));
        televisionSet.setResolution(rs.getString(4));
        televisionSet.setDigitalTunerBand(rs.getString(5));
        televisionSet.setWiFiModule(rs.getBoolean(6));
        televisionSet.setManufacturer(rs.getString(7));
        televisionSet.setSpecialProperty(rs.getString(8));
        televisionSet.setDescription(rs.getString(9));
        televisionSet.setPrice(rs.getInt(10));
        televisionSet.setPlatform(rs.getString(11));
        televisionSet.setUpdate(rs.getString(12));
        televisionSet.setSweep(rs.getString(13));
        televisionSet.setColor(rs.getString(14));
        televisionSet.setSizeWithStand(rs.getString(15));
        televisionSet.setWeightWithStand(rs.getString(16));
        televisionSet.setMainImage(rs.getString(17));
        televisionSet.setAmount(rs.getInt(18));

        return televisionSet;
    }
}

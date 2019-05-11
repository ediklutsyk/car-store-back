package com.store.car.mapper;

import com.store.car.entity.TelevisionSetImage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TelevisionSetImageMapper implements RowMapper<TelevisionSetImage> {
    @Override
    public TelevisionSetImage mapRow(ResultSet rs, int rowNum) throws SQLException {
        TelevisionSetImage televisionSetImage = new TelevisionSetImage();

        televisionSetImage.setId(rs.getInt(1));
        televisionSetImage.setTv_id(rs.getInt(2));
        televisionSetImage.setImage(rs.getString(3));

        return televisionSetImage;
    }
}

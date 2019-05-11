package com.store.car.dao;

import com.store.car.common.entity.Product;
import com.store.car.entity.TelevisionSet;
import com.store.car.entity.TelevisionSetImage;
import com.store.car.mapper.TelevisionSetImageMapper;
import com.store.car.mapper.TelevisionSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TelevisionSetDaoImpl implements TelevisionSetDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public TelevisionSetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("television_set")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<TelevisionSet> getAll() {
        final String sql = "SELECT * FROM television_set";
        return jdbcTemplate.query(sql, new TelevisionSetMapper());
    }

    @Override
    public List<TelevisionSetImage> getImagesByTvId(int tvId) {
        final String sql = "SELECT * FROM image WHERE tv_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tvId}, new TelevisionSetImageMapper());
    }

    @Override
    public TelevisionSet getById(int id) {
        final String sql = "SELECT * FROM television_set WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new TelevisionSetMapper(), id);
    }

    @Override
    public void buy(Product product) {
        product.setAmount(product.getAmount() - 1);
        final String sql = "UPDATE television_set SET amount = ? WHERE id = ?";
        jdbcTemplate.update(sql, product.getAmount(), product.getId());
    }

    @Override
    public void createTV(TelevisionSet televisionSet) {
        Map<String, Object> parameters = new HashMap<>(17);
        parameters.put("name", televisionSet.getName());
        parameters.put("amount", televisionSet.getAmount());
        parameters.put("diagonal", televisionSet.getDiagonal());
        parameters.put("resolution", televisionSet.getResolution());
        parameters.put("digital_tuner_band", televisionSet.getDigitalTunerBand());
        parameters.put("wifi_module", televisionSet.isWiFiModule());
        parameters.put("manufacturer", televisionSet.getManufacturer());
        parameters.put("special_property", televisionSet.getSpecialProperty());
        parameters.put("description", televisionSet.getDescription());
        parameters.put("price", televisionSet.getPrice());
        parameters.put("platform", televisionSet.getPlatform());
        parameters.put("update", televisionSet.getUpdate());
        parameters.put("sweep", televisionSet.getSweep());
        parameters.put("color", televisionSet.getColor());
        parameters.put("size_with_stand", televisionSet.getSizeWithStand());
        parameters.put("weight_with_stand", televisionSet.getWeightWithStand());
        parameters.put("main_image", televisionSet.getMainImage());

        simpleJdbcInsert.execute(parameters);
    }

    @Override
    public void updateTV(TelevisionSet televisionSet) {
        final String sql = "UPDATE television_set SET name = ?, amount = ?, diagonal = ?, resolution = ?," +
                "digital_tuner_band = ?, wifi_module = ?, manufacturer = ?, special_property = ?," +
                "description = ?, price = ?, platform = ?, update = ?, sweep = ?, color = ?," +
                "size_with_stand = ?, weight_with_stand = ?, main_image = ?" +
                " WHERE id = ?";
        jdbcTemplate.update(sql, televisionSet.getName(), televisionSet.getAmount(),
                televisionSet.getDiagonal(), televisionSet.getResolution(), televisionSet.getDigitalTunerBand(),
                televisionSet.isWiFiModule(), televisionSet.getManufacturer(), televisionSet.getSpecialProperty(),
                televisionSet.getDescription(), televisionSet.getPrice(), televisionSet.getPlatform(),
                televisionSet.getUpdate(), televisionSet.getSweep(), televisionSet.getColor(),
                televisionSet.getSizeWithStand(), televisionSet.getWeightWithStand(),
                televisionSet.getMainImage(), televisionSet.getId());
    }

    @Override
    public void deleteTV(int id) {
        final String sql = "DELETE FROM television_set WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

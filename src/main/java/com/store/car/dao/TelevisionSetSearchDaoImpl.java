package com.store.car.dao;

import com.store.car.entity.TelevisionSet;
import com.store.car.mapper.TelevisionSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TelevisionSetSearchDaoImpl implements TelevisionSetSearchDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TelevisionSetSearchDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TelevisionSet> searchByName(String name) {
        name = "%" + name + "%";
        final String sql = "SELECT * FROM television_set WHERE UPPER (name) LIKE UPPER (?)";
        return jdbcTemplate.query(sql, new Object[]{name}, new TelevisionSetMapper());
    }

    @Override
    public List<TelevisionSet> searchByDiagonal(List<String> diagonals) {
        String concatDiagonals = diagonals.stream()
                .map(diagonal -> "'" + diagonal + "'")
                .collect(Collectors.joining(","));

        final String sql = String.format("SELECT * FROM television_set WHERE diagonal IN (%s)", concatDiagonals);
        return jdbcTemplate.query(sql, new TelevisionSetMapper());
    }

    @Override
    public List<TelevisionSet> searchByDigitalTunerBand(List<String> digitalTunerBands) {
        String concatDigitalTunerBands = digitalTunerBands.stream()
                .collect(Collectors.joining(","));
        concatDigitalTunerBands = "%" + concatDigitalTunerBands + "%";
        final String sql = String.format("SELECT * FROM television_set WHERE digital_tuner_band LIKE '%s' ", concatDigitalTunerBands);
        return jdbcTemplate.query(sql, new TelevisionSetMapper());
    }

    @Override
    public List<TelevisionSet> searchByManufacturer(List<String> manufacturers) {
        String concatManufacturers = manufacturers.stream()
                .map(manufacturer -> "'" + manufacturer + "'")
                .collect(Collectors.joining(","));
        final String sql = String.format("SELECT * FROM television_set WHERE manufacturer IN (%s)", concatManufacturers);
        return jdbcTemplate.query(sql, new TelevisionSetMapper());
    }

    @Override
    public List<TelevisionSet> searchByResolution(List<String> resolutions) {
        String concatResolutions = resolutions.stream()
                .map(resolution -> "'" + resolution + "'")
                .collect(Collectors.joining(","));
        final String sql = String.format("SELECT * FROM television_set WHERE resolution IN (%s)", concatResolutions);
        return jdbcTemplate.query(sql, new TelevisionSetMapper());
    }

    @Override
    public List<TelevisionSet> searchBySpecialProps(List<String> specialProps) {
        String concatSpecialProps = specialProps.stream()
                .map(specialProp -> "'" + specialProp + "'")
                .collect(Collectors.joining(","));
        final String sql = String.format("SELECT * FROM television_set WHERE special_property IN (%s)", concatSpecialProps);
        return jdbcTemplate.query(sql, new TelevisionSetMapper());
    }

    @Override
    public List<TelevisionSet> searchByWifiModule(Boolean isWifi) {
        final String sql = "SELECT * FROM television_set WHERE wifi_module IS " + isWifi;
        return jdbcTemplate.query(sql, new TelevisionSetMapper());
    }
}

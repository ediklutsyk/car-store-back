package com.example.tvstore.dao;

import com.example.tvstore.entity.TelevisionSet;

import java.util.List;

public interface TelevisionSetSearchDao {

    List<TelevisionSet> searchByName(String name);

    List<TelevisionSet> searchByDiagonal(List<String> diagonals);

    List<TelevisionSet> searchByDigitalTunerBand(List<String> digitalTunerBands);

    List<TelevisionSet> searchByManufacturer(List<String> manufacturers);

    List<TelevisionSet> searchByResolution(List<String> resolutions);

    List<TelevisionSet> searchBySpecialProps(List<String> specialProps);

    List<TelevisionSet> searchByWifiModule(Boolean isWifi);
}

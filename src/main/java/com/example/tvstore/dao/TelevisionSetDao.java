package com.example.tvstore.dao;

import com.example.tvstore.common.entity.Product;
import com.example.tvstore.entity.TelevisionSet;
import com.example.tvstore.entity.TelevisionSetImage;

import java.util.List;

public interface TelevisionSetDao {

    List<TelevisionSet> getAll();

    List<TelevisionSetImage> getImagesByTvId(int tvId);

    TelevisionSet getById(int id);

    void buy(Product product);

    void createTV(TelevisionSet televisionSet);

    void updateTV(TelevisionSet televisionSet);

    void deleteTV(int id);
}

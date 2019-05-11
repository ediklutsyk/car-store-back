package com.store.car.dao;

import com.store.car.common.entity.Product;
import com.store.car.entity.TelevisionSet;
import com.store.car.entity.TelevisionSetImage;

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

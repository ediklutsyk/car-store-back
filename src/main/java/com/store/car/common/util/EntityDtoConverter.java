package com.store.car.common.util;

public interface EntityDtoConverter<E, D> {

    D toDto(E entity);

    E toEntity(D dto);
}

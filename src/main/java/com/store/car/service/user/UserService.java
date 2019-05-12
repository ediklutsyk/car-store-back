package com.store.car.service.user;

import com.store.car.common.Product;
import com.store.car.db.persistence.User;
import com.store.car.json.request.UserRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);

    List<User> findAll();

    User save(UserRequest userRequest);

    void delete(User user);

    User update(User user);

    Optional<User> findById(Integer id);

    Optional<User> findByToken(String token);

    void buyProduct(User user, Product product);
}
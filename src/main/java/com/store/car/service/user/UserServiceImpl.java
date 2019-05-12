package com.store.car.service.user;

import com.store.car.common.Product;
import com.store.car.db.persistence.Car;
import com.store.car.db.persistence.User;
import com.store.car.exceptions.BadRequestException;
import com.store.car.json.request.UserRequest;
import com.store.car.repositories.CarRepository;
import com.store.car.repositories.UserRepository;
import com.store.car.utils.SecurityUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new BadRequestException("User with such email already exist");
        }
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setActive(1);
        user.setRole("ROLE_USER");
        user.setBalance(new BigDecimal(100000));
        user.setToken(SecurityUtil.md5(userRequest.getEmail() + userRequest.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public void buyProduct(User user, Product product) {
        if (product.getAmount() < 1) {
            throw new BadRequestException("This car is not available for buying now");
        }
        if (user.getBalance().compareTo(product.getPrice()) < 0) {
            throw new BadRequestException("Not enough money");
        }
        product.setAmount(product.getAmount() - 1);
        user.setBalance(user.getBalance().subtract(product.getPrice()));
        userRepository.save(user);
        carRepository.updateCarSetAmountForId(product.getAmount(), product.getId());
    }
}

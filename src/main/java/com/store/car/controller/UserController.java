package com.store.car.controller;

import com.store.car.db.persistence.User;
import com.store.car.exceptions.NotFoundException;
import com.store.car.json.request.UserRequest;
import com.store.car.json.response.LoginResponse;
import com.store.car.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public LoginResponse createUser(@RequestBody @Valid UserRequest userRequest) {
        return new LoginResponse(userService.save(userRequest));
    }

    @GetMapping("/user/user-details/{id}")
    public User getUserDetailsById(@PathVariable("id") Integer id) {
        return userService.findById(id).orElseThrow(() -> new NotFoundException("No such user"));
    }
}
package com.store.car.controller;

import com.store.car.json.response.LoginResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController extends BaseController {

    @RequestMapping("/api/login")
    public LoginResponse login(HttpServletRequest request, HttpServletResponse response) {
        return new LoginResponse(getProfile(request, response));
    }
}

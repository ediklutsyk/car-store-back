package com.store.car.json.response;

import com.store.car.db.persistence.User;

import java.math.BigDecimal;

public class LoginResponse {
    private Integer id;
    private String email;
    private String token;
    private BigDecimal balance;
    private String role;

    public LoginResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.token = user.getToken();
        this.balance = user.getBalance();
        this.role = user.getRole();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

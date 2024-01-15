package com.example.mastercrud.model;

public class LoginResponse {
    private String username;

    public LoginResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
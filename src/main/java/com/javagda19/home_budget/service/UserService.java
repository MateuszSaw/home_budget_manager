package com.javagda19.home_budget.service;

import com.javagda19.home_budget.model.AppUser;

import java.util.List;

public interface UserService {
    void registerUser(String username, String password, String passwordConfirm);

    List<AppUser> getAllUsers();
}

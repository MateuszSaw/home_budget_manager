package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterForm() {
        return "userRegister"; // załaduj widok userRegister (formularz)
    }

    @PostMapping("/register")
    public String submitRegisterForm(@RequestParam(name = "username") String username,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "password-confirm") String passwordConfirm){
        userService.registerUser(username, password, passwordConfirm); // zapisz użytkownika w bazie

        return "redirect:/login"; // przekieruj
    }
}

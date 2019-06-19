package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user/")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getUserList(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "userList";
    }

}

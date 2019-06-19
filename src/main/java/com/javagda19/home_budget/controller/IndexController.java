package com.javagda19.home_budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }
}
